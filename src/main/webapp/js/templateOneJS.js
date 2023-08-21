function saveAboutUsContent() {
    var aboutUsContent = document.getElementById("aboutUsTextArea").value;

    $.ajax({
        type: "POST",
        url: "/your-context-root/controllerWebSite/saveWebSite",
        data: { aboutUs: aboutUsContent },
        success: function() {
            // Optionally provide feedback to the user upon successful save
            alert("About Us content saved successfully.");
        }
    });
}