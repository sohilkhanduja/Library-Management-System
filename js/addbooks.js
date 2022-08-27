function addBooks()
{
    var url = " https://library-management-system-100.herokuapp.com/api/book/add";
    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    var title = document.getElementById("title").value;
    var author = document.getElementById("author").value;
    var year_written = document.getElementById("year_written").value;
    var edition = document.getElementById("edition").value;
    var price = document.getElementById("price").value;
    var isbn = document.getElementById("isbn").value;
    var data = {
        title: title,
        author: author,
        year_written: year_written,
        edition: edition,
        price: price,
        isbn: isbn
    };
    if (title === "" || author === "" || year_written === "" || edition === "" || price === "" || isbn === "") {
        alert("Please fill all the fields");
        return;
    }
    xhr.send(JSON.stringify(data));
    xhr.onreadystatechange = function() {
        if ( xhr.status === 200) {
            alert("Book added successfully");
            window.location.reload();
            xhr.onreadystatechange = null;
        }
        else
        {
            alert("Duplicate book entry");
            xhr.onreadystatechange = null;
        }
    }
}
