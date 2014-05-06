Ext.define('btce.controller.LeftMenuController', {
    extend: 'Ext.app.Controller',

    views: [
        'LeftMenu'
    ]

});

function onUpdateGridClick(){
    try {
        var grid = Ext.getCmp('btce');
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
            console.log(response.responseText);
        },
        failure: function(response, opts) {
            console.log('server-side failure with status code ' + response.status);
        }
    });

};
