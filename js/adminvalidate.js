function checkCredentials() {
    var usernameInput = document.getElementById("Username").value;
    var emailInput = document.getElementById("Email").value;
    var passwordInput = document.getElementById("Password").value;
    localStorage.setItem("username", usernameInput);
    var url = "https://library-management-system-100.herokuapp.com/api/auth/adminlogin";
    var data = {
      username: usernameInput,
      email: emailInput,
      password: passwordInput
    };
    if (usernameInput === "" || emailInput === "" || passwordInput === "") {
        alert("Please fill in all fields");
    }
    else {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", url, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify(data));
        xhr.onreadystatechange = function() {
        if ( xhr.status === 200) {
                window.location.href = "adminDash.html";
                xhr.onreadystatechange = null;
            return;
        }
        else if(xhr.status !== 200){
            alert("Invalid credentials/You are not an admin");
            xhr.onreadystatechange = null;
            return;
        }
    }
    }
  }