<!DOCTYPE HTML>
<html>
<head>
  <script>
    var currentDateTime = new Date();
    var year = currentDateTime.getFullYear();
    var month = (currentDateTime.getMonth() + 1);
    var date = (currentDateTime.getDate() + 1);
    if (date < 10) {
      date = '0' + date;
    }
    if (month < 10) {
      month = '0' + month;
    }
    var dateTomorrow = year + "-" + month + "-" + date;
    var checkinElem = document.querySelector("#checkin-date");
    var checkoutElem = document.querySelector("#checkout-date");
    checkinElem.setAttribute("min", dateTomorrow);
    checkinElem.onchange = function() {
      checkoutElem.setAttribute("min", this.value);
    }
  </script>
  <style>
    body {
      width: 500px;
      margin: 0 auto;
      padding: 50px;
    }

    h2 {
      font-size: 26px;
      margin: 20px 0;
      text-align: center;
    }

    div.elem-group {
      margin: 20px 0;
    }

    div.elem-group.inlined {
      width: 49%;
      display: inline-block;
      float: left;
      margin-left: 1%;
    }

    label {
      display: block;
      font-family: 'Nanum Gothic';
      padding-bottom: 10px;
      font-size: 1.25em;
    }

    input,
    select,
    textarea {
      border-radius: 2px;
      border: 2px solid #777;
      box-sizing: border-box;
      font-size: 1.25em;
      font-family: 'Nanum Gothic';
      width: 100%;
      padding: 10px;
    }

    div.elem-group.inlined input {
      width: 95%;
      display: inline-block;
    }

    textarea {
      height: 250px;
    }

    hr {
      border: 1px dotted #ccc;
    }

    button {
      height: 50px;
      background: #95A5A6;
      border: none;
      color: white;
      font-size: 1.25em;
      font-family: 'Nanum Gothic';
      border-radius: 4px;
      cursor: pointer;
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

    button:hover {
      border: 2px solid black;
    }
  </style>
</head>
<body>
  <h2> Reserve Your Spot </h2>
  <form action="" method="post">
    <div class="elem-group inlined">
      <label for="checkin-date">Select Date</label>
      <input type="date" id="checkin-date" name="checkin-date" required>
    </div>
    <div class="elem-group">
      <select name="sporttype-selection" required>
        <option value="null">Select Sport</option>
        <option value="TABLE_TENNIS">Table Tennis</option>
        <option value="SQUASH">Squash</option>
        <option value="BADMINTON">Badminton</option>
        <option value="LAWN_TENNIS">Lawn Tennis</option>
      </select>
    </div>
    <div class="elem-group">
      <select name="slot-selection" required>
        <option value="null">Select Time Slot</option>
        <option value="9AM to 10AM">9:00 AM - 10:00 AM</option>
        <option value="10AM to 11AM">10:00 AM - 11:00 AM</option>
        <option value="11AM to 12PM">11:00 AM - 12:00 PM</option>
      </select>
    </div>
    <hr>
    <button type="submit">Reserve Spot</button>
  </form>
</body>
</html>