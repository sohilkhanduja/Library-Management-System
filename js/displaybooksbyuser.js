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