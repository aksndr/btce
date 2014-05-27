Ext.define('btce.view.MainContainer' ,{
    extend: 'Ext.Panel',
    alias: 'widget.mainContainer',
    width: 500,
    height: 300,
    layout: {
        type: 'hbox',
        align: 'stretch'
    },
    items: [
        {
            xtype: 'buttonBar',
            width: 0.1,
            flex: 1
        },
        {
            xtype: 'recordsChart',
            flex: 5
        }
    ]

});

