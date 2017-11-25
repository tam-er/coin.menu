fetch("http://localhost:8080/ticker?pair=btcusd").
setInterval(function(){
    fetch("http://localhost:8080/ticker?pair=btcusd").
    then(
        function(response) {
            if(response.status !== 200){
                console.log("response status: " + response.status + ". failed to loead");
                return;
            }
            response.json().then(function(data){
                var well = document.getElementById("price");
                well.innerHTML = "BTC\\USD: " + data.mid + "$"

            })
        }
    ).catch(function(err){
        console.log(err);
    });
}, 10000);


var progress = 0;
var myfctn = function () {
    var progressbar = document.getElementById("progressBar");
    if (progress >= 100) {
        progress = 100;
        progressbar.setAttribute("style", "width:" + 100 + "%; color: white");
        progressbar.innerHTML = 100 + "% Success!";
        progressbar.classList.remove('progress-bar-warning');
        progressbar.classList.add('progress-bar-success');
    }
    else {
        progressbar.setAttribute("style", "width:" + progress + "%; color: white");
        progressbar.innerHTML = progress + "%";
        progress++;
    }
};
setInterval(myfctn, 100)


var generateBtn = document.getElementById("generateBtn");
generateBtn.addEventListener("click", generateWallet);

function generateWallet(){
    fetch("http://localhost:8080/generateWallet").then(
        function(response) {
            if(response.status !== 200){
                console.log("response status: " + response.status + ". failed to loead");
                return;
            }
            response.json().then(function(data){
                var well = document.getElementById("price");
                well.innerHTML = "BTC\\USD: " + data.mid + "$"

            })
        }
    ).catch(function(err){
        console.log(err);
    });
}

