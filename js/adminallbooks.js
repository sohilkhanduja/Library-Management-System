function  getAllBooks() {
    var url = " https://library-management-system-100.herokuapp.com/api/book/all";
    var xhr = new XMLHttpRequest();
    xhr.open("GET", url, true);
    xhr.send(null);
    xhr.onreadystatechange = function() {
        if ( xhr.status === 200) {
         var tableData = (xhr.responseText);
         tableData = JSON.parse(tableData);
        var table = document.getElementById("table");
        var counter = 0;
        for (var i = 0; i < tableData.length; i++) {
            counter +=1;
            var row = table.insertRow(i+1);
            var cell1 = row.insertCell(0);
            var cell2 = row.insertCell(1);
            var cell3 = row.insertCell(2);
            var cell4 = row.insertCell(3);
            var cell5 = row.insertCell(4);
            var cell6 = row.insertCell(5);
            var cell7 = row.insertCell(6);
            var cell8 = row.insertCell(7);
            cell1.innerHTML = counter;
            cell2.innerHTML = tableData[i].title;
            cell3.innerHTML = tableData[i].author;
            cell4.innerHTML = tableData[i].year_written;
            cell5.innerHTML = tableData[i].edition;
            cell6.innerHTML = tableData[i].price;
            cell7.innerHTML = tableData[i].isbn;
            cell8.innerHTML = tableData[i].availability;
            if (cell8.innerHTML === "true") {
                cell8.innerHTML = "Available";
            }
            else {
                cell8.innerHTML = "Not Available";
            }
        }

        }
        xhr.onreadystatechange = null;
    }
}
getAllBooks();