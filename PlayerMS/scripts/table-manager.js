const tableManagerPrototype = {
    createTableHeader: function(headers) {
        let head = document.createElement("thead");
        for (let header of headers) {
            let th = document.createElement("th");
            th.innerText = header;
            head.appendChild(th);
        }
        return head;
    },
    createTableRow: function(values) {
        const tr = document.createElement("tr"); 

        for (let value of values) {
            const td = document.createElement("td");
            td.innerText = value;
            tr.appendChild(td);
        }

        return tr;
    },
    createTableBody: function(headers, values) {
        const body = document.createElement("tbody"); 

        for (let obj of values) {
            let row = this.createTableRow(this.getValuesInOrder(headers, obj));
            body.appendChild(row);
        }
        return body;
    },
    createTable: function(headers, values) {
        const table = document.createElement("table");
        table.appendChild(this.createTableHeader(headers));
        table.appendChild(this.createTableBody(headers, values));
        return table;
    },
    getValuesInOrder: function(headers, obj) {
        const values = [];
        for (let i = 0; i < headers.length; i++) {
            values[i] = obj[headers[i]];
        }
        return values;
    }
}

function TableManager() {

}

TableManager.prototype = tableManagerPrototype;
TableManager.prototype.constructor = TableManager;