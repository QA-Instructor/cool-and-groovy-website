import React, { useEffect, useState } from "react";
import "./WeatherBar.css";
import WeatherTile from "./WeatherTile/WeatherTile";
import Loader from '../Loader/Loader'
import { Container, CardGroup } from 'react-bootstrap'
import './WeatherBar.css'
import axios from "axios";

const client = axios.create({
	baseURL: 'http://99.81.186.138:9090/weather?latitude=51.5074&longitude=-0.1278',
})

const WeatherBar = () => {
	const [weatherData, setWeatherData] = useState()
	const [isLoading, setLoading] = useState(true)

	useEffect(() => {
		const getWeather = async () => {
			let response = await client.get()
			let { weather } = response.data
			setWeatherData(weather)
			setLoading(false)
		}
		getWeather()
	}, [])

	return (
		<div className='WeatherBar bg-secondary px-2 py-3'>
			<Container>
				<CardGroup className='d-flex flex-row flex-nowrap scrolling'>
					{isLoading && <Loader />}
					{weatherData &&
						weatherData.map((weather, i) => {
							return <WeatherTile key={i} data={weather} />
						})}
				</CardGroup>
			</Container>
		</div>
	)
}

export default WeatherBar;
