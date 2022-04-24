const tableManagerPrototype = {
    createTableHeader: function(headers) {
        // headers in the order they appear as an array
        // ['id', 'forename', 'surname'] creates <thead><th>id</th><th>forename</th><th>surname</th></thead>
        let head = document.createElement("thead");
        for (let header of headers) {
            let th = document.createElement("th");
            th.innerText = header;
            head.appendChild(th);
        }
        return head;
    },
    createTableRow: function(values) {
        // values in order they appear as an array
        // ['1', 'bob', 'fred'] creates <tr><td>1</td><td>bob</td><td>fred</td></tr>
        const tr = document.createElement("tr"); // create a table row element, <tr></tr>

        for (let value of values) {
            const td = document.createElement("td");
            td.innerText = value;
            tr.appendChild(td);
        }

        return tr;
    },
    createTableBody: function(headers, values) {
        // values is an array of objects
        const body = document.createElement("tbody"); // <tbody></tbody>

        for (let obj of values) {
            let row = this.createTableRow(this.getValuesInOrder(headers, obj));
            body.appendChild(row);
        }
        return body;
    },
    createTable: function(headers, values) {
        // values is an array of objects
        // headers is an array of the headings/strings
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