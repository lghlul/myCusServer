var spr = spr || {};

spr.login = {
	init : function() {
		this.page.init();
		this.btn.init();
	},

	page : {
		init : function() {
		}
	},

	btn : {
		init : function() {
			this.subBtn();
			this.userName();
			this.password();
		},
		userName : function() {
			$('#userName').bind('keypress', function(event) {
				if (event.keyCode == "13") {
					var $errorInfo = $('#errorInfo');
					if (base.validInputNull($errorInfo)) {
						return;
					}
					var userName = $('#userName').val();
					var password = $('#password').val();
					var action = 'vaildUser.do';
					var data = {
						userName : userName,
						password : password
					};
					base.AJAX_POST(action, data, 'json', function(data) {
						if (data.rCode == 10000) {
							base.getAction("index.do");
						} else if (data.rCode == 10001) {
							bootbox.alert("信息输入错误，请重新输入",function(){
								$("#password").val("");
							});
						}
					});
				}
			});
		},
		password : function() {
			$('#password').bind('keypress', function(event) {
				if (event.keyCode == "13") {
					var $errorInfo = $('#errorInfo');
					if (base.validInputNull($errorInfo)) {
						return;
					}
					var userName = $('#userName').val();
					var password = $('#password').val();
					var action = 'vaildUser.do';
					var data = {
						userName : userName,
						password : password
					};
					base.AJAX_POST(action, data, 'json', function(data) {
						if (data.rCode == 10000) {
							base.getAction("index.do");
						} else if (data.rCode == 10001) {
							bootbox.alert("信息输入错误，请重新输入",function(){
								$("#password").val("");
							});
						}
					});
				}
			});
		},
		subBtn : function() {
			$('#loginBtn').click(function() {
				var $errorInfo = $('#errorInfo');
				if (base.validInputNull($errorInfo)) {
					return;
				}
				var userName = $('#userName').val();
				var password = $('#password').val();
				var action = 'vaildUser.do';
				var data = {
					userName : userName,
					password : password
				};
				base.AJAX_POST(action, data, 'json', function(data) {
					if (data.rCode == 10000) {
						base.getAction("index.do");
					} else if (data.rCode == 10001) {
						bootbox.alert("信息输入错误，请重新输入",function(){
							$("#password").val("");
						});
					}
				});
			});
		}

	}

};