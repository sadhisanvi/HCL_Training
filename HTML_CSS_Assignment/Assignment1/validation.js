function validateBook() {
    var isbn = document.getElementById("isbnId").value;
    var title = document.getElementById("titleId").value;
    var copies = document.getElementById("copiesId").value;
    var publisher = document.getElementById("publisherId").value;
    var author = document.getElementById("authorId").value;

    if(!isValidIsbn(isbn)) {
        document.getElementById("isbnMsg").innerHTML = "Enter valid isbn number (minimum length should be 5)";

        document.getElementById("isbnMsg").style.color="red";
        return false;
    }

    if(!isValidTitle(title)) {
        document.getElementById("titleMsg").innerHTML = "Enter valid title";
        document.getElementById("titleMsg").style.color="red";
        return false;
    }

    if(!isValidCopies(copies)) {
        document.getElementById("copiesMsg").innerHTML = "Enter valid number";
        document.getElementById("copiesMsg").style.color="red";
        return false;
    }

    if(!isValidName(author)) {
        document.getElementById("publisherMsg").innerHTML = "Enter valid publisher name";
        document.getElementById("publisherMsg").style.color="red";
        return false;
    }

    if(!isValidName(author)) {
        document.getElementById("authorMsg").innerHTML = "Enter valid author name";
        document.getElementById("authorMsg").style.color="red";
        return false;
    }

    return true;
}

function isValidIsbn(isbn) {
    return (isbn.length>=5 & isbn.length<=15)?true:false;
}

function isValidTitle(title) {
    return (title.length>5)?true:false;
}

function isValidCopies(copies) {
    return (copies <= 0)?false:true;
}

function isValidName(name) {
    return (name.length>=3)?true:false;
}