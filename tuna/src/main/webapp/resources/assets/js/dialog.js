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
		    			
	    		}).then(result => {
		
	  	          	if (result.value && confirmCallBack) confirmCallBack();
	  	          
	  	        });
	    		
	    	} else if (job === 'checkConfirm') {
	    		
	    		toast.fire({
	    			
		  	          title: title,
		  	          text: text,
		  	          icon: 'question',
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
	    		
	    	} else if (job === 'warnConfirm') {
	    		
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
	    	} else if (job === 'error') {
	    		
	    		toast.fire({
		
		    			title: title, 
		    			text: text, 
		    			icon: 'error',
		    			confirmButtonText: '확인'
		    			
	    		}).then(result => {
		
	  	          	if (result.value && confirmCallBack) confirmCallBack();
	  	          
	  	        });
	    		
	    	} else if (job === 'info') {
	    		
	    		toast.fire({
		
		    			title: title, 
		    			text: text, 
		    			icon: 'info',
		    			confirmButtonText: '확인'
		    			
	    		}).then(result => {
		
	  	          	if (result.value && confirmCallBack) confirmCallBack();
	  	          
	  	        });
	    		
	    	} else if (job === 'question') {
	    		
	    		toast.fire({
		
		    			title: title, 
		    			text: text, 
		    			icon: 'question',
		    			confirmButtonText: '확인'
		    			
	    		}).then(result => {
		
	  	          	if (result.value && confirmCallBack) confirmCallBack();
	  	          
	  	        });
	    		
	    	} 
	  	}
	}
}