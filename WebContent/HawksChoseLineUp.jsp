<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HawksChoseLineUp</title>
</head>
<body style="background:url('image/Hawks.jpg');background-size:cover">
<h1>Altanta Hawks Team Rosters</h1>
<table border = '1'>
		<tbody>
			<tr>
				<td>Name</td>
				<td>Position</td>
				<td>Close Shot</td>
				<td>Three ball</td>
				<td>Ball Control</td>
				<td>Draw Foul</td>
				<td>Free Throw</td>
				<td>Passing</td>
				<td>Attack Consistency</td>
				<td>Steal</td>
				<td>Shot Contest</td>
				<td>Defence Consistency</td>
				<td>Rebound</td>
			</tr>
			<tr>
				<td><b>P.Millsap</b></td>
				<td>PF</td>
				<td>71</td>
				<td>57</td>
				<td>57</td>
				<td>66</td>
				<td>69</td>
				<td>57</td>
				<td>68</td>
				<td>72</td>
				<td>61</td>
				<td>88</td>
				<td>67</td>				
			</tr>
			<tr>
				<td><b>D.Howard</b></td>
				<td>C</td>
				<td>69</td>
				<td>37</td>
				<td>33</td>
				<td>75</td>
				<td>42</td>
				<td>33</td>
				<td>58</td>
				<td>54</td>
				<td>73</td>
				<td>73</td>
				<td>65</td>				
			</tr><tr>
				<td><b>D.Schroder</b></td>
				<td>PG</td>
				<td>48</td>
				<td>69</td>
				<td>80</td>
				<td>67</td>
				<td>75</td>
				<td>76</td>
				<td>66</td>
				<td>63</td>
				<td>60</td>
				<td>56</td>
				<td>34</td>				
			</tr><tr>
				<td><b>K.Bazemore</b></td>
				<td>SF</td>
				<td>51</td>
				<td>63</td>
				<td>67</td>
				<td>55</td>
				<td>76</td>
				<td>58</td>
				<td>69</td>
				<td>65</td>
				<td>56</td>
				<td>69</td>
				<td>48</td>				
			</tr><tr>
				<td>M.Scott</td>
				<td>PF</td>
				<td>66</td>
				<td>60</td>
				<td>41</td>
				<td>55</td>
				<td>76</td>
				<td>38</td>
				<td>62</td>
				<td>55</td>
				<td>56</td>
				<td>47</td>
				<td>59</td>				
			</tr><tr>
				<td>T.Splitter</td>
				<td>C</td>
				<td>61</td>
				<td>42</td>
				<td>30</td>
				<td>65</td>
				<td>76</td>
				<td>33</td>
				<td>40</td>
				<td>58</td>
				<td>71</td>
				<td>60</td>
				<td>60</td>				
			</tr><tr>
				<td>T.Hardaway Jr.</td>
				<td>SG</td>
				<td>54</td>
				<td>63</td>
				<td>72</td>
				<td>62</td>
				<td>83</td>
				<td>65</td>
				<td>41</td>
				<td>55</td>
				<td>51</td>
				<td>38</td>
				<td>31</td>				
			</tr><tr>
				<td><b>T.Sefolosha</b></td>
				<td>SG</td>
				<td>55</td>
				<td>54</td>
				<td>63</td>
				<td>70</td>
				<td>58</td>
				<td>46</td>
				<td>25</td>
				<td>68</td>
				<td>75</td>
				<td>65</td>
				<td>48</td>				
			</tr><tr>
				<td>K.Humphries</td>
				<td>PF</td>
				<td>58</td>
				<td>58</td>
				<td>36</td>
				<td>62</td>
				<td>76</td>
				<td>37</td>
				<td>56</td>
				<td>53</td>
				<td>61</td>
				<td>46</td>
				<td>70</td>				
			</tr><tr>
				<td>J.Jack</td>
				<td>PG</td>
				<td>50</td>
				<td>76</td>
				<td>76</td>
				<td>63</td>
				<td>88</td>
				<td>76</td>
				<td>64</td>
				<td>62</td>
				<td>61</td>
				<td>39</td>
				<td>40</td>				
			</tr>
		</tbody>
	</table>
	
	<FORM ACTION="/WebAPP/ServletController">
             <INPUT TYPE="radio" NAME="Radios" VALUE="Use Default LineUp">
             Use Default LineUp
            <BR>
            <INPUT TYPE="radio" NAME="Radios" VALUE="Choose My Own LineUp">
             Chose My Own LineUp
            <BR>
            <table>
		
			<tbody>
			<tr>
				<td>PG:</td>
				<td>
					<select name = 'PG'>
						<option>D.Schroder</option>
						<option>J.Jack</option>
					</select>
				<td>SG:</td>
				<td>
					<select name = 'SG'>
						<option>T.Hardaway Jr.</option>
						<option>T.Sefolosha</option>
					</select>
					<td>SF:</td>
				<td>
					<select name = 'SF'>
						<option>K.Bazemore</option>
					</select><td>PF:</td>
				<td>
					<select name = 'PF'>
						<option>P.Millsap</option>
						<option>M.Scott</option>
						<option>K.Humphries</option> 
					</select><td>C:</td>
				<td>
					<select name = 'C'>
						<option>D.Howard</option>
						<option>T.Splitter</option>
					</select>
				
			</tr>
			</tbody>
		
		</table>
            <INPUT TYPE="submit" VALUE="Submit">
        </FORM>
</body>
</html>