function returnbook()
{

    var url = "https://library-management-system-100.herokuapp.com/api/borrow/return";
    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    var grid = document.getElementById("table");
    var row = grid.rows;
    var username = localStorage.getItem("username");
    var isbn = "";
    var title = "";
    var author = "";
    for (var i = 1; i < row.length; i++) {
        var checkbox = row[i].cells[0].firstChild;
        if (checkbox.checked) {
            var title = row[i].cells[1].innerHTML;
            var author = row[i].cells[2].innerHTML;
            var isbn = row[i].cells[3].innerHTML;
        }
    }
    var data = {
        username: username,
        title: title,
        author: author,
        isbn: isbn
    };
    if(username === "" || isbn === "" || title === "" || author === "")
    {
        alert("Please select a book to return");
        return;
    }
    xhr.send(JSON.stringify(data));
    xhr.onreadystatechange = function() {
        if ( xhr.status === 200) {
            alert("Book returned successfully");
            window.location.reload();
            window.location.reload();
            xhr.onreadystatechange = null;
        }
        else if(xhr.status !== 200){
            alert("Sorry, there is no book to return");
            xhr.onreadystatechange = null;
        }
    }
}
