function Quiz_Timer(l_end_time, duration_callback) {
    var end_time;
    var timer_div;
    var header_div, time_remaining_div;

    function format_duration(duration) {
        var hours, minutes, seconds;
        var hours_str, minutes_str, seconds_str;

        hours = Math.floor(duration / 3600);
        minutes = Math.floor( (duration % 3600) / 60);
        seconds = duration % 60;

        if (hours == 0) {
            hours_str = '';
        } else {
            hours_str = hours.toString();
            hours_str = hours_str + ':';
        }

        // If there is less than 1 minute left, then just display the seconds
        if (duration < 60) {
            minutes_str = '';
        } else {
            minutes_str = minutes.toString();
            if (hours > 0) {
                // Only add a leading zero for minutes if there is an hour or more left
                if (minutes_str.length == 1)
                    minutes_str = '0' + minutes_str;
            }
            minutes_str = minutes_str + ':';
        }

        seconds_str = seconds.toString();
        if (duration >= 60) {
            // Only add a leading zero for seconds if there is a minute or more left
            if (seconds_str.length == 1)
                seconds_str = '0' + seconds_str;
        } else {
            // Less than a minute left
            seconds_str = seconds_str + 's';
        }

        if (duration <= 0)
            return 'Time is up';
        else
            return hours_str+minutes_str+seconds_str;

    }

    function update() {
        var time_remaining;

        time_remaining = end_time - Math.floor(new Date().getTime() / 1000);
        time_remaining_div.text(format_duration(time_remaining));

        if (time_remaining > 0)
            setTimeout(update, 1000);

        duration_callback(time_remaining);
    }

    function initialize() {
        timer_div = $('<div></div>').attr('id', 'quiz_timer');
        header_div = $('<div></div>').text('Time remaining').css('text-align', 'center').css('font-weight', 'bold');
        timer_div.append(header_div);
        time_remaining_div = $('<div></div>').text('-').css('text-align', 'center');
        timer_div.append(time_remaining_div);

        $('body').append(timer_div);
        setTimeout(update, 1000);
    }

    end_time = l_end_time;
    initialize();
}

