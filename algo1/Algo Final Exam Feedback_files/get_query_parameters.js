// Read a page's GET URL variables and return them as an associative array.
// Adapted from: http://jquery-howto.blogspot.com/2009/09/get-url-parameters-values-with-jquery.html

function get_query_parameters(request_url)
{
    var vars = {}, hash;
    var query_string;
    var hashes;

    query_string = request_url.slice(request_url.indexOf('?') + 1);

    hashes = query_string.split('&');
    for(var i = 0; i < hashes.length; i++)
    {
        hash = hashes[i].split('=');
        vars[hash[0]] = hash[1];
    }
    return vars;
}

// Get javascript query parameters (for use by included scripts e.g. script src="test.js?param1=value1&param2=value2"
// Adapted from: http://stackoverflow.com/questions/2676653/extract-external-javascript-query-string-anchor-value-file-jsfoo-bar
function get_js_query_parameters() {
  var scripts = document.getElementsByTagName('script')
  var currentScript = scripts[scripts.length - 1];
  var scriptUrl = currentScript.src;

  return get_query_parameters(scriptUrl);
}
