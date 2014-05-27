Ext.define('btce.controller.LeftMenuController', {
    extend: 'Ext.app.Controller',

    views: [
        'LeftMenu'
    ]

});

function onUpdateGridClick(){
    try {
        var grid = Ext.getCmp('btceChart');
        grid.getStore().reload();
        grid.getView().refresh();
    } catch (e){
        console.log(e)
    }

};
function onStopServlet(){
    Ext.Ajax.request({
        url: 'http://localhost:8080/btce/servlet',
        method: 'POST',
        type: 'ajax',
        params:{
            command:'stopServlet'
        },
        success: function(response, opts) {
            Ext.aksndr.msg('Stop Servlet result:', response.responseText);
//            Ext.Msg.alert('Stop Servlet Resault', 'Servlet Stopped');
        },
        failure: function(response, opts) {
            Ext.Msg.alert('Stop Servlet result:', 'Failed to stop servlet.');
        }
    });

};

Ext.aksndr = function(){
    var msgCt;
    function createBox(t, s){
        return '<div class="msg"><strong>' + t + '</strong><p>' + s + '</p></div>';
    }
    return {
        msg : function(title, format){
            if(!msgCt){
                msgCt = Ext.core.DomHelper.insertFirst(document.body, {id:'msg-div'}, true);
            }
            var s = Ext.String.format.apply(String, Array.prototype.slice.call(arguments, 1));
            var m = Ext.core.DomHelper.append(msgCt, createBox(title, s), true);
            m.hide();
            m.slideIn('t').ghost("t", { delay: 1000, remove: true});
        }
    };
}();
