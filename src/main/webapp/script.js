var $TABLE = $('#table');
var $BTN = $('#export-btn');
var $EXPORT = $('#export');
var $FORM = $('#form1');
var $SELECT = $('#select');
$('.table-add').click(function () {

  
  var $clone = $TABLE.find('tr.hide').clone(true).removeClass('hide table-line');
  $TABLE.find('table').prepend($clone);
    $(this).off("click");
  
});

$('.table-remove').click(function () {
  $(this).parents('tr').detach();
});



$('.table-edit').click(function () {
  
    
    var currentTD = $(this).parents('tr').find('td.edit');
    var select=$(this).parents('tr').find('td.edit.select');
    $.each(select,function(){
        $(this).prop('disabled', false); 
    });
    $SELECT.prop('disabled', false); 
    var $save = $(this).parents('td').find('button.table-save');
    var $save1 = $(this).parents('td').find('div.table-save');
    var $edit = $TABLE.find('div.table-edit');
    $edit.off("click");
    $save1.removeClass('hide');
    $save.removeClass('hide');
    $(this).addClass('hide');
    var l= $(this).parents('tr').find('td.edit-link'); 
    $.each(l, function () {
          $(this).click(function() {
                      $(this).prop('value','');
                  });
        $(this).children().prop('readonly', false);
//        $(this).children().addClass('submitLink');
//        $(this).children().prop('type',"submit");
        $(this).children().addClass('change-color');
        
    });
   $.each(currentTD, function () {
                  $(this).children().prop('disabled', false);
                  $(this).children().prop('readonly', false);
                  $(this).children().prop('color', "#95c11f");
                  $(this).children().addClass('change-color');
                  
                 
//                  $(this).click(function() {
//                      $(this).empty();
//                  });
              });
});
$('.table-save').click(function () {
   var $add = $TABLE.find('div.table-add');
    $add.on("click");
    var $edit = $TABLE.find('div.table-edit');
    $edit.on("click");
    var currentTD = $(this).parents('tr').find('td.edit');            
    var $edit = $(this).parents('td').find('div.table-edit');
    $edit.removeClass('hide');
    $(this).addClass('hide');
    var l= $(this).parents('tr').find('td.edit-link'); 
    $.each(l, function () {
    
                  $(this).children().prop('contenteditable', false);
                  $(this).children().prop('disabled',false);
                   $(this).click(function() {
                      $(this).empty();
                  });

                                  });
   $.each(currentTD, function () {
                  
                  $(this).children().prop('contenteditable', false);
                  $(this).children().removeClass('change-color');   

              });
});

$(document).ready(function() {  
  $(".selectpicker").selectpicker();
});



