/*let ele=document.getElementById('transact')
console.log(ele)
const url = "http://localhost:8080/transaction";



/*function getTransaction() {
	//const url = "http://jcdemoopenshift1.conygre.com:8081/customer";
//	alert('fetching customers')
	fetch(`${url}``)//promise object to return data from Rest API
		.then(function(response) {console.log(response); return response.json(); }) //resolve , data from resolve is passed to next then
		.then(function(Transactions) {
		console.log(Transactions);
			if (Transactions.length > 0) {
				var temp = "";
				Transactions.forEach(function (Transaction) {
					temp += "<tr>";
					temp += "<td>" + Transaction.trans_date_trans_time + "</td>"
					temp += "<td>" + Transaction.amt + "</td>";
					temp += "<td>" + Transaction.trans_num + "</td>";
					temp += "<td>" + Transaction.customer_id + "</td>";
					temp += "<td>" + Transaction.city + "</td>";
					temp += "<td>" + Transaction.state + "</td>";
					temp += "<td>" + Transaction.city_population + "</td>";
					temp += "<td>" + Transaction.merchant + "</td>";
					temp += "<td>" + Transaction.category + "</td>";
					temp += "<td>" + Transaction.first + "</td>";
					temp += "<td>" + Transaction.last + "</td>";
					temp += "<td>" + Transaction.gender + "</td>";
					temp += "<td>" + Transaction.Job + "</td>";
					temp += "<td>" + Transaction.dob + "</td>";

					temp += "<td> <button onclick='populateInputs(" + Transaction.customer_id +
						")'>Edit</button>&nbsp;<button onClick='deleteCustomer(" +
						Transaction.customer_id + ")'>Delete</button ></td></tr>"

				});
				ele.innerHTML += temp;
                console.log(ele);
			}
		});
}*/
/*
function getTransactionByGender(gender) {
console.log(gender);
	fetch(`${url}/${gender}`)//promise object to return data from Rest API
		.then(function(response) {console.log(response); return response.json(); }) //resolve , data from resolve is passed to next then
		.then(function(Transactions) {
		console.log(Transactions);
			if (Transactions.length > 0) {
				var temp = "";
				Transactions.forEach(function (Transaction) {
					temp += "<tr>";
					temp += "<td>" + Transaction.trans_date_trans_time + "</td>"
					temp += "<td>" + Transaction.amt + "</td>";
					temp += "<td>" + Transaction.trans_num + "</td>";
					temp += "<td>" + Transaction.customer_id + "</td>";
					temp += "<td>" + Transaction.city + "</td>";
					temp += "<td>" + Transaction.state + "</td>";
					temp += "<td>" + Transaction.city_population + "</td>";
					temp += "<td>" + Transaction.merchant + "</td>";
					temp += "<td>" + Transaction.category + "</td>";
					temp += "<td>" + Transaction.first + "</td>";
					temp += "<td>" + Transaction.last + "</td>";
					temp += "<td>" + Transaction.gender + "</td>";
					temp += "<td>" + Transaction.Job + "</td>";
					temp += "<td>" + Transaction.dob + "</td>";
					temp += "<td> <button onclick='populateInputs(" + Transaction.customer_id +
						")'>Edit</button>&nbsp;<button onClick='deleteCustomer(" +
						Transaction.customer_id + ")'>Delete</button ></td></tr>"
				});
				console.log(temp);
//				console.log(ele);
				ele.innerHTML += temp;
                console.log(ele);
			}
		});
}
*/

const url = "http://localhost:8080/transaction";
let currentPage = 1;
const transactionsPerPage = 10; // Number of transactions to display per page

function updatePagination() {
    document.getElementById('currentPage').textContent = currentPage.toString();
}

function getTransactions(page) {
    const start = (page - 1) * transactionsPerPage;
    fetch(`${url}?start=${start}&count=${transactionsPerPage}`)
        .then(function(response) {
            return response.json();
        })
        .then(function(Transactions) {
            if (Transactions.length > 0) {
                let temp = "";
                Transactions.forEach(function(Transaction) {
                   temp += "<tr>";
                   					temp += "<td>" + Transaction.trans_date_trans_time + "</td>"
                   					temp += "<td>" + Transaction.amt + "</td>";
                   					temp += "<td>" + Transaction.trans_num + "</td>";
                   					temp += "<td>" + Transaction.customer_id + "</td>";
                   					temp += "<td>" + Transaction.city + "</td>";
                   					temp += "<td>" + Transaction.state + "</td>";
                   					temp += "<td>" + Transaction.city_population + "</td>";
                   					temp += "<td>" + Transaction.merchant + "</td>";
                   					temp += "<td>" + Transaction.category + "</td>";
                   					temp += "<td>" + Transaction.first + "</td>";
                   					temp += "<td>" + Transaction.last + "</td>";
                   					temp += "<td>" + Transaction.gender + "</td>";
                   					temp += "<td>" + Transaction.Job + "</td>";
                   					temp += "<td>" + Transaction.dob + "</td>";
                   					temp += "<td> <button onclick='populateInputs(" + Transaction.customer_id +
                   						")'>Edit</button>&nbsp;<button onClick='deleteCustomer(" +
                   						Transaction.customer_id + ")'>Delete</button ></td></tr>"
                });
                ele.innerHTML = temp;
                updatePagination();
            }
        });
}

document.getElementById('prevPage').addEventListener('click', () => {
    if (currentPage > 1) {
        currentPage--;
        getTransactions(currentPage);
    }
});

document.getElementById('nextPage').addEventListener('click', () => {
    currentPage++;
    getTransactions(currentPage);
});

// Initial load
getTransactions(currentPage);
