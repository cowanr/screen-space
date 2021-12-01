
<%

String emessage = (String)session.getAttribute("error");
	
	if(emessage!=null){
		
	//
	

%>


<div class="alert alert-danger alert-dismissible fade show" role="alert">
  <strong><%=emessage %></strong>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>

<%		session.removeAttribute("error");
	}
%>
