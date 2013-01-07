$(document).ready(function(){
    
    // Hack to check which of two submit buttons the user activated
    var whichButton = 'save_answers';
    $('input[name=save_answers]').click(function(){
        whichButton = 'save_buttons';
    })
    $('input[name=save_answers]').focus(function(){
        whichButton = 'save_buttons';
    })
    $('input[name=submit_answers]').click(function(){
        whichButton = 'submit_answers';
    })
    $('input[name=submit_answers]').focus(function(){
        whichButton = 'submit_answers';
    })
    
    // Confirm quiz submissions
    $('form').eq(0).submit(function(event){
        if(whichButton === 'submit_answers'){
            var isConfirmed = confirm('Are you sure you want to submit your answers?');
            if(!isConfirmed) event.preventDefault();
        }
    });

    // start quiz timer
    if (typeof QUIZ_TIME_REMAINING !== 'undefined') {
        var quiz_timer = new Quiz_Timer(
            Math.floor(new Date().getTime() / 1000) + Number(QUIZ_TIME_REMAINING),
            function(time_remaining) {
                if (time_remaining <= 0) {
                    $('input[name=submit_answers]').trigger('click');
                }
            }
        );
    }
    
});
