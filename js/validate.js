function checkCredentials() {
  var usernameInput = document.getElementById("Username").value;
  var emailInput = document.getElementById("Email").value;
  var passwordInput = document.getElementById("Password").value;
  localStorage.setItem("username", usernameInput);
  var url = "https://library-management-system-100.herokuapp.com/api/auth/login";
  var data = {
    username: usernameInput,
    email: emailInput,
    password: passwordInput
  };
  
  var xhr = new XMLHttpRequest();
  xhr.open("POST", url, true);
  xhr.setRequestHeader("Content-Type", "application/json");
  xhr.send(JSON.stringify(data));
  xhr.onreadystatechange = function() {
    if ( xhr.status === 200) {
        window.location.href = "borrowerOptions.html";
        return;
    } 
    else if(xhr.status !== 200){
        alert("Invalid credentials");
        xhr.onreadystatechange = null;
        return;
    }
  }
}
function signup() {
  var usernameInput = document.getElementById("Username").value;
  var emailInput = document.getElementById("Email").value;
  var passwordInput = document.getElementById("Password").value;
  localStorage.setItem("username", usernameInput);
  var url = "https://library-management-system-100.herokuapp.com/api/auth/signup";
  var data = {
    username: usernameInput,
    email: emailInput,
    password: passwordInput
  };
  var xhr = new XMLHttpRequest();
  xhr.open("POST", url, true);
  xhr.setRequestHeader("Content-Type", "application/json");
  if (usernameInput === "" || emailInput === "" || passwordInput === "") {
    alert("Please fill in all fields");
    return;
  }
  else if (usernameInput.length < 3 || usernameInput.length > 20) {
    alert("Username must be between 3 and 20 characters");
    return;
  }
  else if (passwordInput.length < 8) {
    alert("Password must be at least 8 characters");
    return;
  }
  xhr.send(JSON.stringify(data));
  xhr.onreadystatechange = function() {
    if ( xhr.status === 200) {
      window.location.href = "borrowerOptions.html";
      
    }
    else if(xhr.status !== 200){
      var json = JSON.parse(xhr.responseText);
      alert(json.message);
      xhr.onreadystatechange = null;
    }
  }
}