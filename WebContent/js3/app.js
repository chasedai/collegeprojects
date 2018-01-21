var tableView;
var motorList;


$(document).ready(function(){
	motorList = new MotorList();
	
	motorList.fetch({
		success: function(data){
			tableView = new TableView({collection: motorList});
			console.log(tableView.$el);
		}
	});
});

