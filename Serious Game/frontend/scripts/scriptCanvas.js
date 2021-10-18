let round = 1;
let endpointName = "round" + round.toString();
let canvasNumber = 2;

function loadGame(output) {
    loadTitleRound(output.roundNumber, output.roundTitle);
    loadScenario(output.scenario.scenarioTitle, output.scenario.scenarioText)
    loadBias(output.biasCollection[0].biasName, output.biasCollection[1].biasName, output.biasCollection[2].biasName);
    loadMeasure(output.measureQuestionCollection[0].measureAnswer, output.measureQuestionCollection[1].measureAnswer, output.measureQuestionCollection[2].measureAnswer);
    // Dit verschilt voor elke ronde per canvas (in data)
    loadInfections(output.canvasCollection[canvasNumber].infections.healthy, output.canvasCollection[canvasNumber].infections.infected, output.canvasCollection[canvasNumber].infections.mutated);
    document.getElementById("all-bias-div").innerHTML = "";
    document.getElementById("bias-table-div").innerHTML = "";
    allBiasen();
    countdown(7);
    loadBiasModals(output.biasCollection);
    openCloseModal(document.getElementById("allBiasesBtn"), document.getElementById("allBiasesModal"), 0);
    openCloseModal(document.getElementById("questionmark-img"), document.getElementById("biasModal"), 1);

    // Newsfeed goes in a loop to get ALL articles needed for the canvas (can be 2 or 3)
    for (let i = 0; i < output.canvasCollection[canvasNumber].newsArticleCollection.length; i++) {
        loadNewsfeed(i, output.canvasCollection[canvasNumber].newsArticleCollection[i].newsArticleTitle, output.canvasCollection[canvasNumber].newsArticleCollection[i].newsArticleMessage, output.canvasCollection[canvasNumber].newsArticleCollection[i].newsArticleSource, output.canvasCollection[canvasNumber].newsArticleCollection[i].newsArticlePopup);
    }

    // Will make the BIAS question default showable
    document.getElementById("qBiasId").click();
}

// THESE ITEMS SHOW ALL THE SAME FOR EVERY CANVAS
// Changes the title to what is send into the function
function loadTitleRound(round, title) {
    document.getElementById("title-round").innerHTML = round + title;
}

// Changes the scenario & text
function loadScenario(scenarioTitle, scenarioText) {
    document.getElementById("scenario-title").innerHTML = scenarioTitle;
    document.getElementById("scenario-text").innerHTML = scenarioText;
}

// Changes the measurements in the question tab
function loadMeasure(answerA, answerB, answerC) {
    document.getElementById("measureA").nextElementSibling.innerHTML = answerA;
    document.getElementById("measureB").nextElementSibling.innerHTML = answerB;
    document.getElementById("measureC").nextElementSibling.innerHTML = answerC;
}

// Changes the biases in the question tab
function loadBias(answerA, answerB, answerC) {
    document.getElementById("biasA").nextElementSibling.innerHTML = answerA;
    document.getElementById("biasB").nextElementSibling.innerHTML = answerB;
    document.getElementById("biasC").nextElementSibling.innerHTML = answerC;
}

// Checks if the bias question has been filled in. If true, access to the measure question is gained.
function validateBias() {
    if (document.getElementById("biasA").checked || document.getElementById("biasB").checked || document.getElementById("biasC").checked) {
        //console.log("Checked");
        return true;
    }
}

// Adds eventlistener on question-bias-tab
document.getElementById("qBiasId").addEventListener("click", clickBiasTab);

function clickBiasTab(e) {
    questionContent = document.getElementsByClassName("question-content");
    questionTab(e, "question-bias");
}

// Adds eventlistener on question-measure-tab
document.getElementById("qMeasureId").addEventListener("click", clickMeasureTab);

function clickMeasureTab(e) {
    if (!validateBias()) {
        alert("Vul eerst de bias vraag in.")
        return;
    }
    questionContent = document.getElementsByClassName("question-content");
    questionTab(e, "question-measure");
}

// Creates a tab function to display text of the chosen tab
function questionTab(evt, questionName) {
    let i, questionContent, questionTabLink;
    questionContent = document.getElementsByClassName("question-content");
    for (i = 0; i < questionContent.length; i++) {
        questionContent[i].style.display = "none";
    }
    questionTabLink = document.getElementsByClassName("question-tab-link");
    for (i = 0; i < questionTabLink.length; i++) {
        questionTabLink[i].className = questionTabLink[i].className.replace(" active", "");
    }
    document.getElementById(questionName).style.display = "block";
    evt.currentTarget.className += " active";
    document.getElementById('question-tab')
}

// Loads the biases in the questionmark button below
function loadBiasModals(bias) {
    makeTable(bias, document.getElementById('bias-table-div'));
}

// Creates both bias tables in HTML
function makeTable(list, div) {
    let table = document.createElement("table");
    let thead = document.createElement('thead');
    let tbody = document.createElement('tbody');

    table.appendChild(thead);
    table.appendChild(tbody);

    // Adding the entire table to the body tag
    div.appendChild(table);

    // Creating and adding data to first row of the table
    let row_1 = document.createElement('tr');
    let heading_1 = document.createElement('th');
    heading_1.innerHTML = "Bias naam";
    let heading_2 = document.createElement('th');
    heading_2.innerHTML = "Omschrijving";
    let heading_3 = document.createElement('th');
    heading_3.innerHTML = "Voorbeeld";

    row_1.appendChild(heading_1);
    row_1.appendChild(heading_2);
    row_1.appendChild(heading_3);
    thead.appendChild(row_1);

    // Looping through all biases that are passed in
    for (let i = 0; i < list.length; i++) {
        let row = document.createElement('tr')
        let rowName = document.createElement('td');
        rowName.innerHTML = list[i].biasName;
        let rowDescription = document.createElement('td');
        rowDescription.innerHTML = list[i].biasDescription;
        let rowExample = document.createElement('td');
        rowExample.innerHTML = list[i].biasExample;

        row.appendChild(rowName);
        row.appendChild(rowDescription);
        row.appendChild(rowExample);
        tbody.appendChild(row);

        // Gives a grey color to a row if the number is uneven
        if (i % 2 == 0) {
            row.style.backgroundColor = 'rgba(128, 128, 128, 0.212)';
        }
    }
}

// Function to set up modals so that it can open and close
function openCloseModal(button, modal, index) {
    // Get the <closeModal> element that closeModals the biasModal
    var closeModal = document.getElementsByClassName("closeModal")[index];

    // When the user clicks on the button, open the biasModal
    button.onclick = function () {
        modal.style.display = "block";
    }

    // When the user clicks on <closeModal> (x), the modal will close
    closeModal.onclick = function () {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the biasModal, the modal will close
    window.addEventListener("click", function (event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    })
}

// THESE ITEMS CHANGE PER ROUND PER CANVAS
// Changes the infections numbers
function loadInfections(healthy, infected, mutated) {
    document.getElementById("healthy-population").innerHTML = healthy;
    document.getElementById("infected-population").innerHTML = infected;
    document.getElementById("mutated-population").innerHTML = mutated;
}

// Changes the articles max of 3 (CHECK IF WE COULD DO MORE)
function loadNewsfeed(articleNumber, newsTitle, newsMessage, newsSource, boolPopup) {
    articleNumber++;
    document.getElementById("title-" + articleNumber).innerHTML = newsTitle;
    document.getElementById("message-" + articleNumber).innerHTML = newsMessage;
    document.getElementById("source-" + articleNumber).innerHTML = newsSource;
    let popup = boolPopup;
}

// Checks if both questions have been filled in.
document.getElementById("next").addEventListener
    ("click", giveAnswer);
function giveAnswer(e) {
    let bias = document.getElementsByName('answer-bias');
    let measure = document.getElementsByName('answer-measure');
    let biasValue;
    let measureValue;
    let biasNumber;
    let measureNumber;

    for (let i = 0; i < bias.length; i++) {
        if (bias[i].checked) {
            biasValue = bias[i].value;
            biasNumber = i;
        }
    }

    for (let j = 0; j < measure.length; j++) {
        if (measure[j].checked) {
            measureValue = measure[j].value;
            measureNumber = j;
        }
    }

    if (biasValue === undefined || measureValue === undefined) {
        alert("U heeft niet allebei de vragen ingevuld.")
    } else {
        nextRound(biasValue, measureValue);
        bias[biasNumber].checked = false;
        measure[measureNumber].checked = false;
    }
}

// Checks the answers and loads the correct new round json file.
function nextRound(biasAnswer, measureAnswer) {
    let newCanvasNumber = checkAnswer(round, canvasNumber, measureAnswer);
    round = round + 1;
    endpointName = "round" + round.toString();

    //console.log(newCanvasNumber);
    canvasNumber = newCanvasNumber;
    fetchRound();
}

// Gets all the biases from the backend with an http request. Backend started with intelliJ.
function allBiasen() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:4567/biases', true);
    xhr.onload = function () {
        if (this.status == 200) {
            const output = JSON.parse(this.responseText);
            makeTable(output, document.getElementById("all-bias-div"));
        }
    }
    xhr.send();
}

function fetchRound() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:4567/' + endpointName, true);
    xhr.onload = function () {
        if (this.status == 200) {
            const output = JSON.parse(this.responseText);
            loadGame(output)
        } else {
            console.log("Niet gevonden")
        }
    }
    xhr.send();
}

// Start first canvas
fetchRound();


// Button that brings you to the login page & alerts you goodbye
function buttonLogoutClick() {
    alert('Tot ziens ');
    window.open('index.html', '_top')
}

// Code for the timer
let timeoutHandle;
// Changes the timer to the given minutes
function countdown(minutes) {
    let seconds = 60;
    let mins = minutes;
    clearInterval(timeoutHandle);

    function tick() {
        if (mins == 1){
            document.getElementById("timer").style.backgroundColor = "red";
        }
        if (seconds <= 1 && mins == 1) {
            alert("De rondetijd is voorbij. Sluit deze melding om verder te gaan.")
            round = round + 1;
            endpointName = "round" + round.toString();
            if (canvasNumber > 0){
                canvasNumber = canvasNumber - 1;
            } else {
                canvasNumber = 0;
            }
            //console.log(canvasNumber);
            fetchRound();
        }
        var counter = document.getElementById("timer");
        var current_minutes = mins - 1
        seconds--;
        counter.innerHTML =
            current_minutes.toString() + ":" + (seconds < 10 ? "0" : "") + String(seconds);
        if (seconds > 0) {
            timeoutHandle = setTimeout(tick, 1000);
        } else {
            if (mins > 1) {
                setTimeout(function () {
                    countdown(mins - 1);
                }, 1000);
            }
        }
    }
    tick();
}