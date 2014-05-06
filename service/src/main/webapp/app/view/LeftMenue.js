Ext.define('btce.view.LeftMenue' ,{
    extend: 'Ext.menu.Menu',
    alias: 'widget.leftMenue',
    plain: true,
    floating: false,
    items: [{
        text: 'Update Grid',
        handler: function() {
            try {
                console.log(Ext.ComponentQuery.query('#recordsGrid'));
            } catch(e) {
                console.log(e);
            }
        }
    },{
        text: 'plain item 2'
    },{
        text: 'Stop Servlet'
    }]
});