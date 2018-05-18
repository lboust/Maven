<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="videoform.css">
<title>Form</title>
</head>
<body>
    <fieldset>
    <form action="" method="POST" id="video" enstype="application/x-www-form-urlencoded">
        <div>
            <label for="video-title">Title</label>
            <input type="text" name="title" id="title" value="${request.getParameter("title")}">
            <p class="validation">${validationErrors.get("title")}</p>
        </div>
        <div>                
            <label for="video-url">Url</label>
            <input type="text" name="url" id="url" value="${request.getParameter("url")}">
            <p class="validation">${validationErrors.get("url")}</p>
        </div>
        <div>                
            <label for="video-duration">Duration (s)</label>
            <input type="text" name="duration" id="duration" value="${request.getParameter("duration")}">
            <p class="validation">${validationErrors.get("duration")}</p>
        </div>
       
        <div>                
                <label for="video-type">Type</label>
                <!-- <input type="text" name="type" id="type" value="${request.getParameter("type")}"> -->
                
                <SELECT name="type" size="1" value="${request.getParameter("type")}">
					<OPTION>trending
					<OPTION>recommended
					
				</SELECT>
				<p class="validation">${validationErrors.get("type")}</p>
            </div>
        <div>
        <div>                
                <label for="video-capture">Capture</label>
                <input type="text" name="capture" id="capture" value="${request.getParameter("capture")}">
                <p class="validation">${validationErrors.get("capture")}</p>
        </div>
        <div>                
            <label for="video-description" cols="30" rows="10">Description</label>
            <textarea name="description"> ${request.getParameter("description")}</textarea>
        </div>
        <div>
            <input type="submit" value="Ajouter une video">
        </div>     

    </form>
    </fieldset>
    
</body>

</html>