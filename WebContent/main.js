'use strict'
{
	const listenImages = [
		'img/3.jpg',
		'img/7.jpg',
		'img/8.jpg',
		'img/12.jpg',
	];

	let currentIndexL = 0;

	const listenImage = document.getElementById('listen');
	listenImage.src = listenImages[currentIndexL];

	let timeoutId;

	function playSlideshow() {
		let target = currentIndexL + 1;
		if (target === listenImages.length) {
			target = 0;
		}
		currentIndexL = target;
		listenImage.src = listenImages[currentIndexL];
		timeoutId = setTimeout(() => {
			playSlideshow();
		}, 2000);
	}

	window.addEventListener('load', () => {
		playSlideshow();
	})

	const playImages = [
		'img/5.jpg',
		'img/9.jpg',

	];

	let currentIndexP = 0;

	const playImage = document.getElementById('play');
	playImage.src = playImages[currentIndexP];

	let timeoutIdP;

	function playSlideshowP() {
		let target = currentIndexP + 1;
		if (target === playImages.length) {
			target = 0;
		}
		currentIndexP = target;
		playImage.src = playImages[currentIndexP];
		timeoutIdP = setTimeout(() => {
			playSlideshowP();
		}, 2000);
	}

	window.addEventListener('load', () => {
		playSlideshowP();
	})

	const makeImages = [
		'img/14.jpg',
		'img/49.jpg',

	];

	let currentIndexM = 0;

	const makeImage = document.getElementById('make');
	makeImage.src = makeImages[currentIndexM];

	let timeoutIdM;

	function playSlideshowM() {
		let target = currentIndexM + 1;
		if (target === makeImages.length) {
			target = 0;
		}
		currentIndexM = target;
		makeImage.src = makeImages[currentIndexM];
		timeoutIdM = setTimeout(() => {
			playSlideshowM();
		}, 2000);
	}

	window.addEventListener('load', () => {
		playSlideshowM();
	})

	const chooseImages = [
		'img/46.jpg',
		'img/44.jpg',
		'img/51.jpg',

	];

	let currentIndexC = 0;

	const chooseImage = document.getElementById('choose');
	chooseImage.src = chooseImages[currentIndexC];

	let timeoutIdC;

	function playSlideshowC() {
		let target = currentIndexC + 1;
		if (target === chooseImages.length) {
			target = 0;
		}
		currentIndexC = target;
		chooseImage.src = chooseImages[currentIndexC];
		timeoutIdC = setTimeout(() => {
			playSlideshowC();
		}, 2000);
	}

	window.addEventListener('load', () => {
		playSlideshowC();
	})

	function checkText() {
		var name = document.customerinfo.name.value;
		var address = document.customerinfo.address.value;

		if (name.length === 0 || address.length === 0) {
			alert('名前か住所が入力されていません！');
			return false;
		}
	}
}