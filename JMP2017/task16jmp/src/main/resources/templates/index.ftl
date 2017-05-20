<!DOCTYPE html>

<html lang="en">

<description>
	<table>
		<thead>
			<tr>
				<td>Title</td>
				<td>Body</td>
				<td>Tags</td>
			</tr>
		</thead>
		<tbody>
<#list notes as note>
			<tr>
				<td>${note.name}</td>
				<td>${note.description}</td>
				<td>
<#list note.tags as tag>
					<span>${tag.name}</span>
</#list>
				</td>
			</tr>
</#list>
		</tbody>
	</table>
</description>

</html>
