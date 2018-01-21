var TableView = Backbone.View.extend({
  collection: MotorList,
  initialize: function(){
   //this.listenTo(this.collection, 'add', this.renderList);
   this.render();
   $('#myTable').dataTable();
  },

  render: function(){
    this.collection.each(function(motor){
    $('#tBody').append(new MotorView({model:motor}).render());
    }, this);
  }

});

