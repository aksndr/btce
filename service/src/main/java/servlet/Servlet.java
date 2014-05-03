package servlet;

import common.broker.BtcRurTicker;
import common.broker.TickRecord;
import org.json.JSONObject;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * User: a.arzamastsev Date: 01.05.14 Time: 18:21
 */

@WebServlet("/servlet")
public class Servlet extends javax.servlet.http.HttpServlet {
    String message;
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
        out.write( getJson());
    }

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
    static BtcRurTicker ticker;
    public List<TickRecord> records = new ArrayList<TickRecord>(2);

    public String getJson() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.accumulate("ticker", records);
        return jsonObj.toString();
    }

    private void tickBTCRURForAnHour() {
        ticker = new BtcRurTicker(records);
        final ScheduledFuture<?> tickerHandle = scheduler.scheduleAtFixedRate(ticker, 0, 15, SECONDS);

        scheduler.schedule(new Runnable() {
            public void run() {
                tickerHandle.cancel(true);
            }
        }, 60 * 60, SECONDS);
    }
}
