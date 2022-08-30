function search()
{
    title = document.getElementById("search");
    if (title.value == "")
    {
        alert("Please enter a search term");
        return false;
    }
    var url = "https:/library-management-system-100.herokuapp.com/api/book/search";
    var xhr = new XMLHttpRequest();
    // data
    var data = {
        "title": title.value
    };
    xhr.open("GET", url, true);
    xhr.send(data);
    xhr.onreadystatechange = function() {
        if ( xhr.status === 200) {
         var tableData = (xhr.responseText);
         tableData = JSON.parse(tableData);
        var table = document.getElementById("table");
        var counter = 0;
        for (var i = 0; i < tableData.length; i++) {
            if(tableData[i].availability === true)
            {
                counter +=1;
                var row = table.insertRow(counter);
                row.id = "row";
                var cell1 = row.insertCell(0);
                var cell2 = row.insertCell(1);
                cell2.id = "title";
                var cell3 = row.insertCell(2);
                cell3.id = "author";
                var cell4 = row.insertCell(3);
                cell4.id = "year_written";
                var cell5 = row.insertCell(4);
                cell5.id = "edition";
                var cell6 = row.insertCell(5);
                cell6.id = "price";
                var cell7 = row.insertCell(6);
                cell7.id = "isbn";
                cell1.innerHTML = "<input type='checkbox' id='checkbox'>";
                cell2.innerHTML = tableData[i].title;
                cell3.innerHTML = tableData[i].author;
                cell4.innerHTML = tableData[i].year_written;
                cell5.innerHTML = tableData[i].edition;
                cell6.innerHTML = tableData[i].price;
                cell7.innerHTML = tableData[i].isbn;
            }
    }
    xhr.onreadystatechange = null;
    }
}
}
search();