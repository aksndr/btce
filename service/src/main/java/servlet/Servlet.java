package servlet;

import broker.Bot;
import common.BtcRurTicker;
import common.StatRecord;
import common.TickRecord;
import common.utils.RecordsTube;
import org.json.JSONObject;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.HOURS;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * User: a.arzamastsev Date: 01.05.14 Time: 18:21
 */
//@WebServlet(urlPatterns = "/btce/servlet")
public class Servlet extends javax.servlet.http.HttpServlet {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
    static BtcRurTicker ticker;
    public List<TickRecord> records = new ArrayList<TickRecord>(250);
    RecordsTube<TickRecord> rt = new RecordsTube<TickRecord>(3);
    List<StatRecord> statistic = new ArrayList(100);
    private ScheduledFuture<?> tickerHandle;
    private ScheduledFuture<?> botHandle;
    private Bot bot;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
    super.init(servletConfig);
        tickBTCRURForAnHour();
    }
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/javascript");
//        response.setContentType("application/json");
//        response.setContentType("application/x-json");
        Writer out = response.getWriter();
        String message = null;

        if ("getJson".equals(request.getParameter("command"))){
            message = getJson();
        } else if ("stopServlet".equals(request.getParameter("command"))) {
            message = stopServlet();
        }
        out.write(message);
    }

    public String getJson() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.accumulate("ticker", records);
        return jsonObj.toString();
    }

    public String stopServlet() {
        try {
            tickerHandle.cancel(true);
            scheduler.shutdown();
        } catch (SecurityException se){
            return "fail";
        }
        return "stopped";
    }

    private void tickBTCRURForAnHour() {
        ticker = new BtcRurTicker(records, rt);
        bot = new Bot(rt, statistic);

        tickerHandle = scheduler.scheduleAtFixedRate(ticker, 0, 15, SECONDS);
        botHandle = scheduler.scheduleAtFixedRate(bot, 47, 15, SECONDS);
        scheduler.schedule(new Runnable() {
            public void run() {
                tickerHandle.cancel(true);
            }
        }, 10, HOURS);


    }
}
