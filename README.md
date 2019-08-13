
<color name="colorPrimary_70">#B3F4B709</color>  
<color name="alert_70">#B3F4B709</color>  
<color name="error_70">#B3E64A19</color>  
<color name="success_70">#B3689F38</color>
```

# Botones

![Colores](http://pappstor.com/real/buttons.gif)
```xml
<!-- Buttons Styles -->  
<style name="materialButton" parent="Widget.MaterialComponents.Button">  
 <item name="android:textSize">15sp</item>  
 <item name="android:fontFamily">@font/bold</item>  
 <item name="android:textAllCaps">false</item>  
 <item name="colorAccent">@color/colorPrimary</item>  
 <item name="android:textColor">@android:color/white</item>  
  
</style>  
  
<style name="materialSummitButton" parent="Widget.MaterialComponents.Button">  
 <item name="android:textSize">15sp</item>  
 <item name="android:fontFamily">@font/bold</item>  
 <item name="android:textAllCaps">false</item>  
 <item name="colorAccent">@color/colorPrimary</item>  
 <item name="android:textColor">@android:color/white</item>  
  
</style>  
  
<style name="outlineMaterialButton" parent="Widget.MaterialComponents.Button.OutlinedButton">  
 <item name="android:textSize">15sp</item>  
 <item name="android:fontFamily">@font/bold</item>  
 <item name="android:textAllCaps">false</item>  
 <item name="strokeColor">@color/out_lined_stroke</item>  
  
</style>  
  
<style name="textMaterialButton" parent="Widget.MaterialComponents.Button.TextButton">  
 <item name="android:textSize">15sp</item>  
 <item name="android:fontFamily">@font/bold</item>  
 <item name="android:textAllCaps">false</item>  
</style>  
  
<style name="errorTextMaterialButton" parent="Widget.MaterialComponents.Button.TextButton">  
 <item name="android:textSize">15sp</item>  
 <item name="android:fontFamily">@font/bold</item>  
 <item name="android:textAllCaps">false</item>  
 <item name="rippleColor">@color/error</item>  
 <item name="android:textColor">@color/error_text_color</item>  
</style>  
  
<style name="alertTextMaterialButton" parent="Widget.MaterialComponents.Button.TextButton">  
 <item name="android:textSize">15sp</item>  
 <item name="android:fontFamily">@font/bold</item>  
 <item name="android:textAllCaps">false</item>  
 <item name="rippleColor">@color/alert</item>  
 <item name="android:textColor">@color/alert_text_color</item>  
  
</style>  
  
<style name="successTextMaterialButton" parent="Widget.MaterialComponents.Button.TextButton">  
 <item name="android:textSize">15sp</item>  
 <item name="android:fontFamily">@font/bold</item>  
 <item name="android:textAllCaps">false</item>  
 <item name="rippleColor">@color/success</item>  
 <item name="android:textColor">@color/sucess_text_color</item>  
</style>
```
# Textos
![Colores](http://pappstor.com/real/text.gif)
```xml
<style name="Button" parent="TextAppearance.MaterialComponents.Button">  
 <item name="android:textSize">15sp</item>  
 <item name="android:letterSpacing">0.09</item>  
 <item name="android:lineSpacingExtra">1sp</item>  
 <item name="android:textColor">@color/text_color</item>  
 <item name="android:fontFamily">@font/bold</item>  
 <item name="android:textAllCaps">false</item>  
 <item name="android:textColorPrimaryDisableOnly">@color/colorPrimary</item>  
</style>  
  
<style name="Head1Bold" parent="android:TextAppearance.Material">  
 <item name="android:fontFamily">@font/bold</item>  
 <item name="android:textSize">34sp</item>  
  
 <item name="android:textColor">@color/base_1</item>  
</style>  
  
<style name="Head2Bold" parent="android:TextAppearance.Material">  
 <item name="android:fontFamily">@font/bold</item>  
 <item name="android:textSize">28sp</item>  
 <item name="android:lineSpacingExtra">6sp</item>  
 <item name="android:textColor">@color/base_1</item>  
</style>  
   
<style name="Head3Bold" parent="android:TextAppearance.Material">  
 <item name="android:fontFamily">@font/bold</item>  
 <item name="android:textSize">22sp</item>  
 <item name="android:lineSpacingExtra">6sp</item>  
 <item name="android:textColor">@color/base_1</item>  
</style>  
  
<style name="Head4" parent="android:TextAppearance.Material">  
 <item name="android:textSize">20sp</item>  
 <item name="android:letterSpacing">0.02</item>  
 <item name="android:lineSpacingExtra">4sp</item>  
 <item name="android:textColor">@color/base_1</item>  
</style>  
  
<style name="Head4Regular" parent="Head4">  
 <item name="android:fontFamily">@font/medium</item>  
</style>  
    
<style name="Head4Bold" parent="Head4">  
 <item name="android:fontFamily">@font/bold</item>  
</style>  
  
<style name="Body1" parent="android:TextAppearance.Material">  
 <item name="android:textSize">17sp</item>  
 <item name="android:lineSpacingExtra">7sp</item>  
 <item name="android:textColor">@color/base_1</item>  
</style>  
 
<style name="Body1Light" parent="Body1">  
 <item name="android:fontFamily">@font/book</item>  
</style>  
  
<style name="Body1Bold" parent="Body1">  
 <item name="android:fontFamily">@font/bold</item>  
</style>  
  
<style name="Body1Regular" parent="Body1">  
 <item name="android:fontFamily">@font/medium</item>  
</style>  
  
<style name="Body2" parent="android:TextAppearance.Material">  
 <item name="android:textSize">15sp</item>  
 <item name="android:lineSpacingExtra">5sp</item>  
 <item name="android:textColor">@color/base_1</item>  
</style>  
  
<style name="Body2Light" parent="Body2">  
 <item name="android:fontFamily">@font/book</item>  
</style>  
  
<style name="Body2Bold" parent="Body2">  
 <item name="android:fontFamily">@font/bold</item>  
</style>  
  
<style name="Body2Regular" parent="Body2">  
 <item name="android:fontFamily">@font/medium</item>  
</style>  
  
<style name="Caption1" parent="android:TextAppearance.Material">  
 <item name="android:textSize">13sp</item>  
 <item name="android:lineSpacingExtra">3sp</item>  
 <item name="android:textColor">@color/base_1</item>  
</style>  
  
<style name="Caption1Regular" parent="Caption1">  
 <item name="android:fontFamily">@font/medium</item>  
</style>  
  
<style name="Caption1Bold" parent="Caption1">  
 <item name="android:fontFamily">@font/bold</item>  
</style>  
  
<style name="Caption2" parent="android:TextAppearance.Material">  
 <item name="android:textSize">11sp</item>  
 <item name="android:textColor">@color/base_1</item>  
</style>  
  
<style name="Caption2Regular" parent="Caption2">  
 <item name="android:fontFamily">@font/medium</item>  
</style>  
  
<style name="Caption2Bold" parent="Caption2">  
 <item name="android:fontFamily">@font/bold</item>  
</style>
```
# TopBar
![Colores](http://pappstor.com/real/topbar.jpg)
# BottomBar
![Colores](http://pappstor.com/real/bottomBar.gif)
# Bottom Navigation
![Colores](http://pappstor.com/real/bottomNavigation.gif)
# Toast - SnackBars
![Colores](http://pappstor.com/real/toasts.gif)
# Forms
![Colores](http://pappstor.com/real/forms.gif)
# List
![Colores](http://pappstor.com/real/list1.png)
![Colores](http://pappstor.com/real/list2.png)
![Colores](http://pappstor.com/real/list3.png)
![Colores](http://pappstor.com/real/list4.png)
# Dialogs

The file explorer is accessible using the button in left corner of the navigation bar. You can create a new file by clicking the **New file** button in the file explorer. You can also create folders by clicking the **New folder** button.

## Switch to another file

All your files and folders are presented as a tree in the file explorer. You can switch from one to another by clicking a file in the tree.

## Rename a file

You can rename the current file by clicking the file name in the navigation bar or by clicking the **Rename** button in the file explorer.

## Delete a file

You can delete the current file by clicking the **Remove** button in the file explorer. The file will be moved into the **Trash** folder and automatically deleted after 7 days of inactivity.

## Export a file

You can export the current file by clicking **Export to disk** in the menu. You can choose to export the file as plain Markdown, as HTML using a Handlebars template or as a PDF.


# Synchronization

Synchronization is one of the biggest features of StackEdit. It enables you to synchronize any file in your workspace with other files stored in your **Google Drive**, your **Dropbox** and your **GitHub** accounts. This allows you to keep writing on other devices, collaborate with people you share the file with, integrate easily into your workflow... The synchronization mechanism takes place every minute in the background, downloading, merging, and uploading file modifications.

There are two types of synchronization and they can complement each other:

- The workspace synchronization will sync all your files, folders and settings automatically. This will allow you to fetch your workspace on any other device.
	> To start syncing your workspace, just sign in with Google in the menu.

- The file synchronization will keep one file of the workspace synced with one or multiple files in **Google Drive**, **Dropbox** or **GitHub**.
	> Before starting to sync files, you must link an account in the **Synchronize** sub-menu.

## Open a file

You can open a file from **Google Drive**, **Dropbox** or **GitHub** by opening the **Synchronize** sub-menu and clicking **Open from**. Once opened in the workspace, any modification in the file will be automatically synced.

## Save a file

You can save any file of the workspace to **Google Drive**, **Dropbox** or **GitHub** by opening the **Synchronize** sub-menu and clicking **Save on**. Even if a file in the workspace is already synced, you can save it to another location. StackEdit can sync one file with multiple locations and accounts.

## Synchronize a file

Once your file is linked to a synchronized location, StackEdit will periodically synchronize it by downloading/uploading any modification. A merge will be performed if necessary and conflicts will be resolved.

If you just have modified your file and you want to force syncing, click the **Synchronize now** button in the navigation bar.

> **Note:** The **Synchronize now** button is disabled if you have no file to synchronize.

## Manage file synchronization

Since one file can be synced with multiple locations, you can list and manage synchronized locations by clicking **File synchronization** in the **Synchronize** sub-menu. This allows you to list and remove synchronized locations that are linked to your file.


# Publication

Publishing in StackEdit makes it simple for you to publish online your files. Once you're happy with a file, you can publish it to different hosting platforms like **Blogger**, **Dropbox**, **Gist**, **GitHub**, **Google Drive**, **WordPress** and **Zendesk**. With [Handlebars templates](http://handlebarsjs.com/), you have full control over what you export.

> Before starting to publish, you must link an account in the **Publish** sub-menu.

## Publish a File

You can publish your file by opening the **Publish** sub-menu and by clicking **Publish to**. For some locations, you can choose between the following formats:

- Markdown: publish the Markdown text on a website that can interpret it (**GitHub** for instance),
- HTML: publish the file converted to HTML via a Handlebars template (on a blog for example).

## Update a publication

After publishing, StackEdit keeps your file linked to that publication which makes it easy for you to re-publish it. Once you have modified your file and you want to update your publication, click on the **Publish now** button in the navigation bar.

> **Note:** The **Publish now** button is disabled if your file has not been published yet.

## Manage file publication

Since one file can be published to multiple locations, you can list and manage publish locations by clicking **File publication** in the **Publish** sub-menu. This allows you to list and remove publication locations that are linked to your file.


# Markdown extensions

StackEdit extends the standard Markdown syntax by adding extra **Markdown extensions**, providing you with some nice features.

> **ProTip:** You can disable any **Markdown extension** in the **File properties** dialog.


## SmartyPants

SmartyPants converts ASCII punctuation characters into "smart" typographic punctuation HTML entities. For example:

|                |ASCII                          |HTML                         |
|----------------|-------------------------------|-----------------------------|
|Single backticks|`'Isn't this fun?'`            |'Isn't this fun?'            |
|Quotes          |`"Isn't this fun?"`            |"Isn't this fun?"            |
|Dashes          |`-- is en-dash, --- is em-dash`|-- is en-dash, --- is em-dash|


## KaTeX

You can render LaTeX mathematical expressions using [KaTeX](https://khan.github.io/KaTeX/):

The *Gamma function* satisfying $\Gamma(n) = (n-1)!\quad\forall n\in\mathbb N$ is via the Euler integral

$$
\Gamma(z) = \int_0^\infty t^{z-1}e^{-t}dt\,.
$$

> You can find more information about **LaTeX** mathematical expressions [here](http://meta.math.stackexchange.com/questions/5020/mathjax-basic-tutorial-and-quick-reference).


## UML diagrams

You can render UML diagrams using [Mermaid](https://mermaidjs.github.io/). For example, this will produce a sequence diagram:

```mermaid
sequenceDiagram
Alice ->> Bob: Hello Bob, how are you?
Bob-->>John: How about you John?
Bob--x Alice: I am good thanks!
Bob-x John: I am good thanks!
Note right of John: Bob thinks a long<br/>long time, so long<br/>that the text does<br/>not fit on a row.

Bob-->Alice: Checking with John...
Alice->John: Yes... John, how are you?
```

And this will produce a flow chart:

```mermaid
graph LR
A[Square Rect] -- Link text --> B((Circle))
A --> C(Round Rect)
B --> D{Rhombus}
C --> D
```