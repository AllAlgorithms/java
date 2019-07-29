/**
 * validate.js
 * 
 * The All ▲lgorithms validator CLI
 * 
 * Author: Carlos Abraham Hernandez
 * https://abranhe.com (abraham@abranhe.com)
 */
'use strict';

const glob = require('glob');
const path = require('path');
const camelCase = require('camelcase');
const chalk = require('chalk');

const getFiles = (src, callback) => glob(src + '/**', callback);

getFiles('../', (err, res) => {
	if (err) {
		console.log('Error', err);
	}

	let invalid = false;

	res.map((file) => {
		// Accept only valid Java Files
		if (path.extname(file) !== '.java') {
			return;
		}

		if (path.basename(file, '.java') !== camelCase(path.basename(file, '.java'), { pascalCase: true })) {
			console.log(`${chalk.red(path.basename(file))} does not follow the correct style.`);
			invalid = true;
		} else {
			console.log(`${chalk.green(path.basename(file))} is ok.`);
		}
	});

	if (invalid) {
		throw new TypeError(`Expected the All ▲lgorithms structure.`);
	}
});
