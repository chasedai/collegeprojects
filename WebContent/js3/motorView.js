//调用modalview，显示dialog的东西
var MotorView = Backbone.View.extend({
  model: Motor,
  tagName:'tr',
  events:{
	  "click .more": "alertStatus",
	  "click .editMotor":"showEditDialog"
  },
  alertStatus: function(e){
	  var motor1=this.model;
	  $('#modal').html(new ModalView({model:motor1}).render());
	  $('#modal').modal('show');
  },
  showEditDialog: function(e){
	  var motor2=this.model;
	  $('#modal').html(new ModalView({model:motor2}).render2());
	  $('#modal').modal('show');
  },
    render:function(){
		 var template= _.template($('#motorlist').html(), this.model.toJSON());
		return this.$el.html(template);
		
  }
});
