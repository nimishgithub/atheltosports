<html>

<head>
  <style>
    h1 {
      text-align: center;
    }

    html,
    body {
      align-items: center;
      background: #f2f4f8;
      border: 0;
      display: flex;
      font-family: Helvetica, Arial, sans-serif;
      font-size: 16px;
      height: 100%;
      justify-content: center;
      margin: 0;
      padding: 0;
    }

    form {
      --background: white;
      --border: rgba(0, 0, 0, 0.125);
      --borderDark: rgba(0, 0, 0, 0.25);
      --borderDarker: rgba(0, 0, 0, 0.5);
      --bgColorH: 0;
      --bgColorS: 0%;
      --bgColorL: 98%;
      --fgColorH: 210;
      --fgColorS: 50%;
      --fgColorL: 38%;
      --shadeDark: 0.3;
      --shadeLight: 0.7;
      --shadeNormal: 0.5;
      --borderRadius: 0.125rem;
      --highlight: #306090;
      background: white;
      border: 1px solid var(--border);
      border-radius: var(--borderRadius);
      box-shadow: 0 1rem 1rem -0.75rem var(--border);
      display: flex;
      flex-direction: column;
      padding: 1rem;
      position: relative;
      overflow: hidden;
    }

    form .email, form .email a {
      color: hsl(var(--fgColorH), var(--fgColorS), var(--fgColorL));
      font-size: 0.825rem;
      order: 4;
      text-align: center;
      margin-top: 0.25rem;
      outline: 1px dashed transparent;
      outline-offset: 2px;
      display: inline;
    }

    form>div {
      order: 2;
    }

    label {
      display: flex;
      flex-direction: column;
    }

    input {
      border: 1px solid var(--border);
      border-radius: var(--borderRadius);
      box-sizing: border-box;
      font-size: 1rem;
      height: 2.25rem;
      line-height: 1.25rem;
      margin-top: 0.25rem;
      order: 2;
      padding: 0.25rem 0.5rem;
      width: 15rem;
      transition: all 0.25s;
    }

    input[type="submit"] {
      color: hsl(var(--bgColorH), var(--bgColorS), var(--bgColorL));
      background: hsl(var(--fgColorH), var(--fgColorS), var(--fgColorL));
      font-size: 0.75rem;
      font-weight: bold;
      margin-top: 0.625rem;
      order: 4;
      outline: 1px dashed transparent;
      outline-offset: 2px;
      padding-left: 0;
      text-transform: uppercase;
    }

    input[type="submit"]:focus {
      background: hsl(var(--fgColorH), var(--fgColorS), calc(var(--fgColorL) * 0.85));
    }

    input[type="submit"]:hover {
      background: hsl(var(--fgColorH), var(--fgColorS), calc(var(--fgColorL) * 0.85));
    }

    input[type="submit"]:active {
      background: hsl(var(--fgColorH), calc(var(--fgColorS) * 2), calc(var(--fgColorL) * 1.15));
      transition: all 0.125s;
    }
  </style>
</head>

<body>
  <form name="registration" onsubmit="return formValidation()" action="login.htm" method="post">
    <table>
      <tr>
        <h1>Athleto Northeastern Login</h1>
      </tr>

      <tr>
        <td><label for="email">Email:</label></td>
        <td><input type="text" name="email" id="email" placeholder="Email"></td>
      </tr>
      <tr>
        <td><label for="password">Password:</label></td>
        <td><input type="password" name="password" id="password" placeholder="Password"></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" style="margin:0px auto; display:block;" class="signupbtn" value="Submit" /></td>
      </tr>
    </table>
    <div class="email">
      <a href="signup.htm">Create Account</a>
    </div>
    <script>
      const email = document.getElementById("email");
      const password = document.getElementById("password");
      // function for form verification
      function formValidation() {
        if (!email.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)) {
          alert("Please enter a valid email!");
          email.focus();
          return false;
        }
        // checking password
        if (!password.value.match(/^.{5,15}$/)) {
          alert("Password length must be between 5-15 characters!");
          password.focus();
          return false;
        }
        return true;
      }
    </script>
  </form>
</body>