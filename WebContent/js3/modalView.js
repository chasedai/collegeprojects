var ModalView = Backbone.View.extend({
	model : Motor,
	events : {
		"click #newmotor" : "newMotor",
		"click #save" : "saveMotor",
		"click #delete" : "deleteMotor"
	},
	render : function() {
		var template = _.template($('#modal_details').html(), this.model
				.toJSON());
		return this.$el.html(template);

	},
	render2 : function() {
		var template = _.template($('#modal_editMotor').html(), this.model
				.toJSON());
		return this.$el.html(template);

	},
	saveMotor : function() {
		if ($("#motorId").val() == "") {
			var motor = new Motor();
		} else {
			var motor = new Motor({
				id : $("#motorId").val()
			});
		}
		motor.fetch({});
		motor.save({
			make : $("#make").val(),
			year : $("#year").val(),
			mileage : $("#mileage").val(),
			colour : $("#colour").val(),
			engine : $("#engine").val(),
			picture : $("#pictureedit").val(),
			description : $("#descriptionedit").val()
		}, {
			success : function() {
				$('#modal').modal('hide');
				$("#tBody").empty();
				motorList = new MotorList();
				motorList.fetch({
					success: function(data){
						console.log("data fetched");
						tableView = new TableView({collection: motorList});
						console.log(tableView.$el);
					}
				});
			}
		});
	},
	newMotor : function() {
		$("#motorId").val("");
		$("#make").val("");
		$("#year").val("");
		$("#mileage").val("");
		$("#colour").val("");
		$("#engine").val("");
		$("#pictureedit").val("");
		$("#descriptionedit").val("");
	},
	deleteMotor : function() {
		var motor = new Motor({id:$("#motorId").val()});
		motor.destroy({
			
			success:function(){
				alert("Deleted");
				$('#modal').modal('hide');
				$("#tBody").empty();
				motorList = new MotorList();
				motorList.fetch({
					success: function(data){
						console.log("成功获取数据");
						tableView = new TableView({collection: motorList});
						console.log(tableView.$el);
					}
				});
			}
		}
		);
	},
});
