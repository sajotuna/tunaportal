// dialog
class Dialogs {
	
	static dialog(job, title, text, confirmCallBack) {
		
	    let toast = Swal.mixin({
	      buttonsStyling: false,
	      target: '#page-container',
	      customClass: {
	        confirmButton: 'btn btn-dark m-1',
	        cancelButton: 'btn btn-light m-1',
	        input: 'form-control'
	      }
	    });
	    
	    open();
	    
	    function open() {
	    	
	    	if(job === 'success') {
	    		
	    		toast.fire({
		
		    			title: title, 
		    			text: text, 
		    			icon: 'success',
		    			confirmButtonText: '확인'
		    			
	    		});
	    		
	    	} else if (job === 'confirmGreen') {
	    		
	    		toast.fire({
	    			
		  	          title: title,
		  	          text: text,
		  	          icon: 'success',
		  	          showCancelButton: true,
		  	          customClass: {
		  	            confirmButton: 'btn btn-dark m-1',
		  	            cancelButton: 'btn btn-light m-1'
		  	          },
		  	          confirmButtonText: '확인',
		  	          cancelButtonText: '취소',
	  	          
	  	        }).then(result => {
		
	  	          	if (result.value) confirmCallBack();
	  	          
	  	        });
	    		
	    	} else if (job === 'confirmRed') {
	    		
	    		toast.fire({
	    			
	  	          title: title,
	  	          text: text,
	  	          icon: 'warning',
	  	          showCancelButton: true,
	  	          customClass: {
	  	            confirmButton: 'btn btn-danger m-1',
	  	            cancelButton: 'btn btn-light m-1'
	  	          },
	  	          confirmButtonText: '확인',
	  	          cancelButtonText: '취소',
			  	          
	  	       }).then(result => {
		
		  	        if (result.value) confirmCallBack();
		  	        
		  	   });
	    	}
	  	}
	}
}