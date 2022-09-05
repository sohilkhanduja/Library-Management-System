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
                var date1 = tableData[i].date;
                var date2  = tableData[i].returnDate;
                date1 = date1.reverse();
                date2 = date2.reverse();
                for(var j = 0; j < date1.length/2; j++) {

                }
                cell1.innerHTML = "<input type='checkbox' id='checkbox'>";
                cell4.innerHTML = tableData[i].isbn;
                cell2.innerHTML = tableData[i].title;
                cell3.innerHTML = tableData[i].author;
                cell5.innerHTML = date1;
                cell6.innerHTML = date2;
        }
        }
        xhr.onreadystatechange = null;
    }
}
}
getAllBooks();
