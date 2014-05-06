Ext.define('btce.view.LeftMenu' ,{
    extend: 'Ext.menu.Menu',
    alias: 'widget.leftMenu',
    plain: true,
    floating: false,
    items: [{
        text: 'Update Grid',
        handler: onUpdateGridClick
//        function() {
//            try {
//                console.log(Ext.ComponentQuery.query('#recordsGrid'));
//            } catch(e) {
//                console.log(e);
//            }
//        }
    },{
        text: 'plain item 2'
    },{
        text: 'Stop Servlet',
        handler:  onStopServlet
    }]
});