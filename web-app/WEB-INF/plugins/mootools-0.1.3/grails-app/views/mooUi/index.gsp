<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Mootools UI </title>         
        <g:javascript library="mootools"/>
        <moores:calendar/>
        <moores:more/>
        <moores:tab/>
		<moores:window/>
    </head>
    <body>
    <moo:calendar name="date1"/>
    <br/><br/><br/>
    <moo:tabTitle titles="${['Tab1':'China','Tab2':'美国','test3':'英国']}">
      <moo:tabPanel id="Tab1">
         <p>Hello Tab1</p>
      </moo:tabPanel>
      <moo:tabPanel id="Tab2">
         <p>Hello Tab2</p>
      </moo:tabPanel>
      <moo:tabPanel id="test3">
         <p>Hello 测试</p>
      </moo:tabPanel>
    </moo:tabTitle>
<a href="#" onclick="openWindow('openwin');">open window</a>
	<moo:window title="test" id="openwin">
		mootools ddddddddddfffffffffffffffeeeeeeeeeee<br>
		<input type="button" value="button" onclick="closeWindow('openwin');"/>
	</moo:window><br>
<a href="#" onclick="openWindow('open');">open window</a>
	<moo:window title="testtest" id="open">
		mootools ddddddddddfffffffffffffffeeeeeeeeeee<br>
		<input type="button" value="button" onclick="closeWindow('open');"/>
	</moo:window>
    </body>
</html>
