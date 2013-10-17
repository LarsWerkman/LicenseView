<h1>LicenseView</h1>

A quick little library I made, because I needed to add Licenses to my app.
The only solutions I could find on the internet they used Webviews. I didn't want to make use of a webview so that's why I made this library, as a fun little side project.

![image](https://lh3.googleusercontent.com/-O3oyz6G1hZM/Ul8co7clvGE/AAAAAAAAAzI/n6KohHVy3WA//LicenseView.jpg)
![image](https://lh3.googleusercontent.com/-r6dL21kgVzo/Ul8cozKkGRI/AAAAAAAAAy8/Q89YXDW4o4k//Screenshot_2013-10-17-00-22-39_framed.png)


<h2>Documentation</h2>

To add the LicenseView to a layout.
```xml
<com.larswerkman.licenseview.LicenseView
	android:id="@+id/licenseview"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
```

Adding the License xml to the LicenseView.

```java
LicenseView licenseView = (LicenseView) findViewById(R.id.licenseView1);
try {
	licenseView.setLicenses(R.xml.licenses);
} catch (NotFoundException e1) {
} catch (XmlPullParserException e1) {
} catch (IOException e1) {
}
```	
Creating the License xml. first add a folder called 'xml' to your Resource folder 'res', then create a file called licenses.xml (Or the name you want).
This is a sample file how it should be structured.

```xml
<?xml version="1.0" encoding="utf-8" ?>
<licenses>
    <license name="android-support-v4.jar" type="file">
	/*
	 * Copyright (C) 2013 The Android Open Source Project
	 *
	 * Licensed under the Apache License, Version 2.0 (the "License");
	 * you may not use this file except in compliance with the License.
	 * You may obtain a copy of the License at
	 *
	 *      http://www.apache.org/licenses/LICENSE-2.0
	 *
	 * Unless required by applicable law or agreed to in writing, software
	 * distributed under the License is distributed on an "AS IS" BASIS,
	 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	 * See the License for the specific language governing permissions and
	 * limitations under the License.
	 */
 </license>
 <license name="ActionbarSherlock" type="library">
    Copyright 2012 Jake Wharton
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	   http://www.apache.org/licenses/LICENSE-2.0
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
 </license>
</licenses>
```

The root tag should always be called ```<licenses>``` and the child tag ```<license>``` .
The license tag has 2 attributes ```name``` and ```type```.

The name specifies the name of the library.
The type attribute can be 2 things, either ```file``` or ```library``` depending if its a jar or a project.


<H2>License</H2>
	
 	 Copyright 2013 Lars Werkman
 	
 	 Licensed under the Apache License, Version 2.0 (the "License");
 	 you may not use this file except in compliance with the License.
 	 You may obtain a copy of the License at
 	
 	     http://www.apache.org/licenses/LICENSE-2.0
 	
 	 Unless required by applicable law or agreed to in writing, software
	 distributed under the License is distributed on an "AS IS" BASIS,
 	 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 	 See the License for the specific language governing permissions and
 	 limitations under the License.
 	

<h2>Devoleped By</h2>
**Lars Werkman**
