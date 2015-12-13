/*
* Assignment 2 JS
* Ming Chi
*/
function doUpdate()
{
	document.getElementById("cv-name").textContent=document.getElementById("username").value;
	var addr=document.getElementById("useraddr").value;
	var tel=document.getElementById("usertel").value;
	var email=document.getElementById("useremail").value;
	document.getElementById("cv-addr-contact").textContent=addr+" | "+tel+" | "+email;


}


function newSection()
{
	if(false==confirm("Have you saved the session you are editing?\nIf not, please submit it first.\n\nAdd a new Section now?"))
	{return;}
	document.getElementById("sec-name").value="";
	document.getElementById("sec-content").value="";
}

function addSection()
{
	var m_secname=document.getElementById("sec-name").value;
	var str=document.getElementById("sec-content").value;
	var nospc1=m_secname.replace(/\s/g,'');
	var nospc2=str.replace(/\s/g,'');
	if(nospc1.length*nospc2.length!=0)
	{
		if(document.getElementById(nospc1)!=null)
		{
			alert("This section already exists.");
		}
		var sections=document.getElementById("cv-content");
		var newsec=document.createElement("div");
		var secheader=document.createElement("h2");
		secheader.textContent=m_secname;
		var content=document.createElement("div");

		content.innerHTML=str.replace(/\n/g,"<br>");
		newsec.appendChild(secheader);
		newsec.appendChild(content);
		newsec.setAttribute("class","cv-section");
		newsec.setAttribute("id",nospc1);
		sections.appendChild(newsec);
	}
	else
	{
		alert("Please do not leave section header or content empty.");
	}

}

function delSection()
{
	var m_title=prompt("Please provide Section Header going to be removed","");
	if(m_title==null)
	{
		alert("Please don't provide empty section header. Unable to remove.");
	}	
	var nospc1=m_title.replace(/\s/g,'');
	if(document.getElementById(nospc1)!=null)
	{
		var child=document.getElementById(nospc1);
		var parent=child.parentNode;
		parent.removeChild(child);
		alert("Section ["+nospc1+"] removed.");
	}
	else
	{
		alert("That section does not exist. Unable to remove.");
	}	
}

function updateSection()
{
	var m_secname=document.getElementById("sec-name").value;
	var str=document.getElementById("sec-content").value;
	var nospc1=m_secname.replace(/\s/g,'');
	var nospc2=str.replace(/\s/g,'');
	if(nospc1.length*nospc2.length!=0)
	{
		if(document.getElementById(nospc1)!=null)
		{
			var newsec=document.getElementById(nospc1);
			newsec.setAttribute("id",nospc1);
			newsec.firstElementChild.textContent=m_secname;
			newsec.lastElementChild.innerHTML=str.replace(/\n/g,"<br>");
		}
		else
		{
			alert("This section does not exist. You have to add section before update.");
		}
	}
	else
	{
		alert("Please do not leave section header or content empty.");
	}	
}

function addSubSection()
{
	var m_title=prompt("Please enter Sub-Section Title","");
	var m_content=prompt("Please enter Sub-Section content.\nYou can edit them later in the Sectoin Content area","");
	if(m_title==null||m_content==null)
	{
		alert("Please do not input empty sub-section header or content.");
		return;
	}
	var nospc1=m_title.replace(/\s/g,'');
	var nospc2=m_content.replace(/\s/g,'');
	if(nospc1.length*nospc2.length!=0)
	{
		var old=document.getElementById("sec-content").value;
		document.getElementById("sec-content").value=old+"<h4>"+m_title+"</h4>"+"<div>"+m_content+"</div>";
	}
	else
	{
		alert("Please do not input empty sub-section header or content.");
	}

}

function onClearAll()
{
	window.location.reload();
}
