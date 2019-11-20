var app = app || {}
app = (()=>{
	let run=x=>$.getScript(x+'/resources/js/cmm/router.js',()=>{
		$.extend(new Session(x))
		onCreate()
	})
	let _, js, css, img
	let init=()=>{
		_ = $.ctx(),
		js = $.js(),
		css = $.css(),
		img = $.img()
		
	}
	let onCreate=()=>{
		init()
		setContentView()
	}
	let setContentView=()=>{
		alert('화면 들어옴')
		$('<table><tr></tr></table>')
		.css({
			width:'80%',
			height:'800px',
			border:'1px solid black',
			margin:'0 auto'
		})
		.appendTo('body')
		$('<td/>',{id:'left'})
		.css({
			width:'20%',
			height:'100%',
			border:'1px solid black',
			'vertical-align':'top'
		})
		.appendTo('tr')
		$('<td/>',{id:'right'})
		.appendTo('tr')
		.css({
			width:'80%',
			height:'100%',
			border:'1px solid black',
			'vertical-align':'top'
		})
		$.each(['naver','bugs','cgv'],(i,j)=>{
			$('<div/>')
			.text(j)
			.css({
				width:'100%',
				height:'50px',
				border:'1px solid black',
				'text-align':'center'
			})
			.appendTo('#left')
			.click(function(){
				$(this).css({'background-color':'lightblue'})
				$(this).siblings().css({'background-color':'white'});
				_ =$.ctx()
				alert($(this).text())
				switch($(this).text()){
				case 'naver': 
					$('#right').empty()  //remove는 틀마져 싹 날리는것. 안에 내용만 날리는게 empty
					$.getJSON(_+'/naver',d=>{  //d가 저쪽에서 list 니깐. map이면 d.list d가 hashmap인경우??...
			
					$.each(d,(i,j)=>{     //i 가 인덱스 j 는 {}로 담겨져 있음
						$('<div/>')
//						.text(j.origin+'----'+j.trans)//tag와 tag사이에 넣을때  text cf) attr은 태그안에 속성 값 넣을때
						.html('<h2>'+j.origin+'</h2><h4>'+j.trans+'</h4>') //글자에 뭔가 태그 넣고 싶을때는 html을 써야한다.
						.css({
							width:'40%',
							height:'40%',
							border:'3px solid red',
							float:'left'
						})
						.appendTo('#right')
					})
				})
				break;
				case 'bugs':
					$.getJSON(_+'/bugs',d=>{
						let pager = d.pager
						let list = d.list
						$('#right').empty() 
						//no title artist thumbnail
						
						$('<table id="content"><tr id="head"></tr></table>')
						.css({width: '99%',
								height: '50px',
				              border: '1px solid black'})
						.appendTo('#right')
						$.each(['No.','앨범','제목','가수'],(i, j)=>{
							$('<th/>')
							.html('<b>'+j+'</b>')
							.css({width: '25%',height: '100%',
					              border: '1px solid black'})
							.appendTo('#head')
						})
						$.each(list, (i, j)=>{
							$('<tr><td>'+j.seq+'</td><td><img src="'+j.thumbnail+'"/></td><td>'+j.title+'</td><td>'+j.artist+'</td></tr>')
							.css({width: '25%',height: '100%',
					              border: '1px solid black'})
							.appendTo('#content tbody')
						})
						$('#content tr td').css({border: '1px solid black'})
						$.each(['1','2','3'],(i,j)=>{
							$('<span><a href="#">'+j+'</a></span>')
							.css({
								'place':'center'
							})
							.appendTo('#right')
						})
						
				})
				break;
				case 'cgv':
					$('#right').empty()
					$.getJSON(_+'/cgv',d=>{
						$.each(d,(i,j)=>{
							$('<div><img src="'+j.photo+'"></br>'+j.title+'</br>'+j.percent+'</br>'+j.info+'</div>')
							.css({
								border:'3px solid red',
								float:'left'
							})
							.appendTo('#right')
						})
					})
				break;
	
				}
				
			})
		})
	}
	return {run}
	
})()