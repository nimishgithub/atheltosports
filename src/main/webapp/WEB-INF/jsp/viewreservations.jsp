<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <style>
            body {
              font-family: 'lato', sans-serif;
            }
            .container {
              max-width: 1000px;
              margin-left: auto;
              margin-right: auto;
              padding-left: 10px;
              padding-right: 10px;
            }

            h2 {
              font-size: 26px;
              margin: 20px 0;
              text-align: center;
            }

            h2 small {
              font-size: 0.5em;
            }

            .responsive-table li {
              border-radius: 3px;
              padding: 25px 30px;
              display: flex;
              justify-content: space-between;
              margin-bottom: 25px;
            }

            .responsive-table .table-header {
              background-color: #95A5A6;
              font-size: 14px;
              text-transform: uppercase;
              letter-spacing: 0.03em;
            }

            .responsive-table .table-row {
              background-color: #ffffff;
              box-shadow: 0px 0px 9px 0px rgba(0, 0, 0, 0.1);
            }

            .responsive-table .col-1 {
              flex-basis: 10%;
            }

            .responsive-table .col-2 {
              flex-basis: 40%;
            }

            .responsive-table .col-3 {
              flex-basis: 25%;
            }

            .responsive-table .col-4 {
              flex-basis: 25%;
            }

            @media (max-width: 767px) {
              .responsive-table .table-header {
                display: none;
              }

              .responsive-table li {
                display: block;
              }

              .responsive-table .col {
                flex-basis: 100%;
              }

              .responsive-table .col {
                display: flex;
                padding: 10px 0;
              }

              .responsive-table .col:before {
                color: #6C7A89;
                padding-right: 10px;
                content: attr(data-label);
                flex-basis: 50%;
                text-align: right;
              }
            }
          </style>
    </head>
    <body>
        <div class="container">
          <h2> Reservations </h2>
          <ul class="responsive-table">
            <li class="table-header">
              <div class="col col-1">Date</div>
              <div class="col col-2">Slot</div>
              <div class="col col-3">Sport</div>
            </li>
            <c:forEach var="reservation" items="${requestScope.reservations}">
               <li class="table-row">
                  <div class="col col-1" data-label="date">${reservation.date}</div>
                  <div class="col col-2" data-label="slot">${reservation.slot}</div>
                  <div class="col col-3" data-label="sporttype">${reservation.sportType}</div>
               </li>
            </c:forEach>
          </ul>
        </div>
    </body>
</html>



