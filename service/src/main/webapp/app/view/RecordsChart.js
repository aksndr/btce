Ext.define('btce.view.RecordsChart' ,{
    extend: 'Ext.chart.Chart',
    alias: 'widget.recordsChart',
    id: 'btceChart',
    title: 'Records',
    store: 'Records',
    style: 'background:#fff',
    animate: true,
    legend: {
        position: 'bottom'
    },
    axes: [{
        type: 'Numeric',
        position: 'left',
        fields: ['high', 'buy', 'last', 'sell', 'low'],
        title: 'Opp values',
        minorTickSteps: 1,
        grid: {
            odd: {
                opacity: 1,
                fill: '#ddd',
                stroke: '#bbb',
                'stroke-width': 0.5
            }
        }
    }, {
        type: 'Category',
        position: 'bottom',
        fields: ['time'],
        title: 'time',
        label: {
            rotate: {
                degrees: 270
            }
        }
    }],
    series: [{
        type: 'line',
        highlight: false,
        axis: 'left',
        xField: 'time',
        yField: 'high',
        showMarkers: false
    },{
        type: 'line',
        highlight: false,
        axis: 'left',
        xField: 'time',
        yField: 'buy',
        showMarkers: false
    },{
        type: 'line',
        highlight: false,
        axis: 'left',
        xField: 'time',
        yField: 'last',
        showMarkers: false
    },{
        type: 'line',
        highlight: false,
        axis: 'left',
        xField: 'time',
        yField: 'sell',
        showMarkers: false
    },{
        type: 'line',
        highlight: false,
        axis: 'left',
        xField: 'time',
        yField: 'low',
        showMarkers: false
    }]
});