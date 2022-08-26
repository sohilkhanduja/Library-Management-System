function  getAllusers() {
    var url = " https://library-management-system-100.herokuapp.com/api/test/admin";
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
            // check if the user is admin or not]);
            if(tableData[i].roles[0].name === "ROLE_ADMIN") {
                continue;
            }
            counter +=1;
            var row = table.insertRow(counter);
            var cell1 = row.insertCell(0);
            var cell2 = row.insertCell(1);
            var cell3 = row.insertCell(2);
            cell1.innerHTML = counter;
            cell2.innerHTML = tableData[i].username;
            cell3.innerHTML = tableData[i].email;
        }
        }
        xhr.onreadystatechange = null;

    }
}
getAllusers();