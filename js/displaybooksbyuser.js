function  getAllBooks() {
    var url = "https://library-management-system-100.herokuapp.com/api/book/all/user";
    var xhr = new XMLHttpRequest();
    xhr.open("GET", url, true);
    var username = localStorage.getItem("username");
    xhr.send(null);
    xhr.onreadystatechange = function() {
        if ( xhr.status === 200) {
         var tableData = (xhr.responseText);
         tableData = JSON.parse(tableData);
        var table = document.getElementById("table");
        var counter = 0;
        for (var i = 0; i < tableData.length; i++) {
            if(tableData[i].username === username ) {
            counter +=1;
            var row = table.insertRow(counter);
            var cell1 = row.insertCell(0);
            var cell2 = row.insertCell(1);
            var cell3 = row.insertCell(2);
            var cell4 = row.insertCell(3);
            var cell5 = row.insertCell(4);
            var cell6 = row.insertCell(5);
            cell1.innerHTML = counter;
            cell2.innerHTML = tableData[i].username;
            cell3.innerHTML = tableData[i].isbn;
            cell4.innerHTML = tableData[i].title;
            cell5.innerHTML = tableData[i].author;
            var date1 = tableData[i].date;
            var rev = date1.length - 1;
            for(var k = 0; i < date1.length/2; k++)
            {
                var temp = date1[k];
                date1[k] = date1[rev];
                date1[rev] = temp;
                rev--;
            }
            cell5.innerHTML = date1;
            var date2 = tableData[i].returnDate;
            rev = date2.length - 1;
            for(var k = 0; i < date2.length/2; k++)
            {
                var temp = date2[k];
                date2[k] = date2[rev];
                date2[rev] = temp;
                rev--;
            }
            cell6.innerHTML = tableData[i].dateReturned;
            // var ce11 1 is checkbox
            cell1.innerHTML = "<input type='checkbox' id='checkbox'>";
            cell4.innerHTML = tableData[i].isbn;
            cell2.innerHTML = tableData[i].title;
            cell3.innerHTML = tableData[i].author;
        }
        }
        xhr.onreadystatechange = null;
    }
}
}
getAllBooks();
