
function getDefaultBoard() {
	return [["", "r", "", "r", "", "r", "", "r", "", "r"],
	                    ["r", "", "r", "", "r", "", "r", "", "r", ""],
	                    ["", "r", "", "r", "", "r", "", "r", "", "r"],
	                    ["r", "", "r", "", "r", "", "r", "", "r", ""],
	                    ["", "", "", "", "", "", "", "", "", ""],
	                    ["", "", "", "", "", "", "", "", "", ""],
	                    ["", "b", "", "b", "", "b", "", "b", "", "b"],
	                    ["b", "", "b", "", "b", "", "b", "", "b", ""],
	                    ["", "b", "", "b", "", "b", "", "b", "", "b"],
	                    ["b", "", "b", "", "b", "", "b", "", "b", ""]];
}

function drawDefaultBoard(id) {
	drawFromArray(id, getDefaultBoard());
}

function drawFromArray(id, theArray) {
	var black = "img/black.png";
	var dark = "img/dark.png";
	var light = "img/light.png";
	var red = "img/red.png";
	var y = 0;
	var startBlack = true;

	var element = document.getElementById(id);
	clearChildNodes(element);
	var table = document.createElement("table");
	for(var rowIndex in theArray) {
		var x = 0;
		var startBlack = !startBlack;
		var row = theArray[rowIndex];
		var tablerow = document.createElement("tr");
		for(var cellIndex in row) {
			var cell = row[cellIndex];
			var tableCellElement = document.createElement("td");
			var blackOrRed = null;
			if(startBlack) {
				blackOrRed = dark;
			} else {
				blackOrRed = light;
			}
			if(startBlack) {
				tableCellElement.setAttribute("class", "dark");
			} else {
				tableCellElement.setAttribute("class", "light");
			}
			startBlack = !startBlack;
			if(cell != "") {
				var imageblock = document.createElement("img");
				if(cell == "r") {
					imageblock.setAttribute("src", red);
					imageblock.setAttribute("onclick", "alert('" + x + " " + y + "' + ' r');");
				} else {
					imageblock.setAttribute("onclick", "alert('" + x + " " + y + "' + ' b');");
					imageblock.setAttribute("src", black);
				}
				imageblock.setAttribute("style", "display : block;");
				imageblock.setAttribute("href", "#");
				tableCellElement.appendChild(imageblock);
			} else {
				tableCellElement.setAttribute("onclick", "alert('" + x + " " + y + "');");
			}
			
			tablerow.appendChild(tableCellElement);
			x++;
		}
		table.appendChild(tablerow);
		y++;
	}
	element.appendChild(table);
}

function clearChildNodes(element) {
	while(element.hasChildNodes()) element.removeChild(element.firstChild);
}

