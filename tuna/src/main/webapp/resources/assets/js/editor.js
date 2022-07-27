/**
 * 
 */
	function ckfinder() {
				let ckfinder = document.querySelector('#ckfinder');

				if (ckfinder) {
					ClassicEditor
						.create(document.querySelector('#ckfinder'),
							{
								fontColor: {
									colors: [
										{
											color: 'hsl(0, 0%, 0%)',
											label: 'Black'
										},
										{
											color: 'hsl(0, 0%, 30%)',
											label: 'Dim grey'
										},
										{
											color: 'hsl(0, 0%, 60%)',
											label: 'Grey'
										},
										{
											color: 'hsl(0, 0%, 90%)',
											label: 'Light grey'
										},
										{
											color: 'hsl(0, 0%, 100%)',
											label: 'White',
											hasBorder: true
										},
										{
											color: 'hsl(0, 75%, 60%)',
											label: 'Red'
										},
										{
											color: 'hsl(30, 75%, 60%)',
											label: 'Orange'
										},
										{
											color: 'hsl(60, 75%, 60%)',
											label: 'Yellow'
										},
										{
											color: 'hsl(90, 75%, 60%)',
											label: 'Light green'
										},
										{
											color: 'hsl(120, 75%, 60%)',
											label: 'Green'
										},
										{
											color: 'hsl(150, 75%, 60%)',
											label: 'Aquamarine'
										},
										{
											color: 'hsl(180, 75%, 60%)',
											label: 'Turquoise'
										},
										{
											color: 'hsl(210, 75%, 60%)',
											label: 'Light blue'
										},
										{
											color: 'hsl(240, 75%, 60%)',
											label: 'Blue'
										},
										{
											color: 'hsl(270, 75%, 60%)',
											label: 'Purple'
										}
									]
								},

								language: 'ko',
								ckfinder: {
									uploadUrl: getContextPath() + 'ckImage?_csrf=' + token
								},
								image: {
									styles: ["alignLeft", "alignCenter", "alignRight"],
									toolbar: [
										"imageStyle:alignLeft",
										"imageStyle:alignCenter",
										"imageStyle:alignRight",
										"|",
										"imageTextAlternative",

									],
	            			      resizeUnit: 'px',
            		            resizeOptions: [
            		                {
            		                    name: 'resizeImage:original',
            		                    label: 'Original',
            		                    value: null
            		                },
            		                {
            		                    name: 'resizeImage:100',
            		                    label: '100px',
            		                    value: '100'
            		                },
            		                {
            		                    name: 'resizeImage:200',
            		                    label: '200px',
            		                    value: '200'
            		                }
            		            ] 
								},

							})
						.then(editor => {
							window.editor = editor;
						})
						.catch(error => {
							console.error('There was a problem initializing the classic editor.', error);
						});
				}


			}


			function getContextPath() {
				var pathName = window.location.pathname.substring(1);
				var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
				var path_root = window.location.protocol + '//' + window.location.host + '/' + webName + '/';
				return path_root;
			}
			
