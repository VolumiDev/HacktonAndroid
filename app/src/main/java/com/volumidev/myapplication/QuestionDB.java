package com.volumidev.myapplication;

import java.io.Serializable;
import java.util.ArrayList;

public class QuestionDB implements Serializable {
    private Question[] questions_table;
    private int diff_selected; //from 0 to 2

    QuestionDB(int diff){
        diff_selected = diff;
        switch(diff_selected){
            case 1:
                questions_table = mediumquestions();
                break;
            case 2:
                questions_table = hardquestions();
                break;
            default:
                questions_table = easyquestions();
        }
    }

    public Question[] easyquestions(){
        String [] Preguntas = {
                "Is the Earth a planet?",
                "The Sun is a star",
                "How many layers does the Earth have?",
                "How many planets are there in the solar system?",
                "Which is the smallest planet in the solar system?",
                "In which position in the solar system is planet Earth?",
                "What is the celestial body that illuminates the Earth?",
                "What is the name of the celestial bodies that orbit around a star?",
                "What is the name of our natural satellite?",
                "What is the name of the closest star to Earth?",
                "In which galaxy is the solar system located?",
                "Which planet is known as the “red planet”?",
                "What is the name of the largest planet in the solar system?",
                "Which is the planet closest to the Sun?",
                "What are stars?",
                "Which planet in the solar system has rings visible from Earth?",
                "Which planet is known as the “blue planet”?",
                "Which is the second planet closest to the Sun?",
                "What natural phenomenon occurs when the Moon blocks the Sun’s light?",
                "Which is the planet farthest from the Sun in our solar system?",
                "Which is the largest continent in the world?",
                "Which is the smallest ocean in the world?",
                "What is the equator?",
                "What is the most abundant gas in Earth’s atmosphere?",
                "What is the lowest point on Earth?",
                "What natural phenomenon occurs when the Earth shakes?",
                "What does NASA stand for?",
                "What was NASA’s first manned space mission?",
                "In what year was NASA founded?",
                "Who was the first human to walk on the Moon during the Apollo 11 mission?"
        };
        //PRIMERA RESPUESTA CORRECTA, SEPARADAS POR GUION
        String [] Respuestas = {
                "Yes-No-It doesn’t exist-It is a satellite",
                "Yes-No-It doesn’t exist-It is a black hole",
                "3-4-2-6",
                "8-3-6-5",
                "Mercury-Venus-Saturn-Pluto",
                "Third-Second-Fourth-Sixth",
                "The Sun-The Moon-Mars-Venus ",
                "Planets-Comets-Galaxies-Meteorites",
                "Moon-Star-Volcano-Asteroid",
                "Sun-Sirius-Alpha Centauri-Moon",
                "Milky Way-Andromeda-Triangulum-Octagonal",
                "Mars-Mercury-Jupiter-Pluto",
                "Jupiter-Earth-Uranus-Mars",
                "Mercury-Earth-Mars-Venus",
                "Celestial bodies that emit light and heat-Natural satellites-Space rocks- Small planets",
                "Saturn-Uranus-Neptune-Jupiter",
                "Earth-Mars-Neptune-Venus",
                "Venus-Jupiter-Mars-Earth",
                "Solar eclipse-Lunar eclipse-High tide-Aurora borealis",
                "Neptune-Saturn-Uranus-Pluto",
                "Asia-Africa-North America-Europe",
                "Arctic Ocean-Atlantic Ocean-Indian Ocean-Pacific Ocean",
                "An imaginary line that divides the Earth-A mountain range-An ocean-A season of the year",
                "Nitrogen-Hydrogen-Oxygen-Carbon dioxide",
                "Dead Sea-Coral Barrier-Grand Canyon-Mount Everest",
                "Earthquake-Storm-Tornado-Hurricane",
                "National Aeronautics and Space Administration-National Association for Space Activities-National Air and Space Agency-North American Space Agency",
                "Mercury-Redstone 3 (Freedom 7)-Apollo 11-Gemini 4-Apollo 1",
                "1958-1965-1955-1960",
                "Neil Armstrong-John Glenn-Buzz Aldrin-Michael Collins"
        };
        Question [] easy_q = new Question[Preguntas.length];
        Question q;
        for(int i=0; i<Preguntas.length; i++){
            q = new Question(0, false);
            ArrayList<String> q_answers = answer_splitter(Respuestas[i]);
            q.setTitle(Preguntas[i]);
            q.setPossible_answers(q_answers);
            q.setCorrect_answer(q_answers.get(0));
            easy_q[i] = q;
        }

        return easy_q;

    }
//------------------------------------------------------------------------------------------
    public Question[] mediumquestions(){
        String [] Preguntas = {
                "The Earth's atmosphere has ' ' layers.",
                "The exosphere contains gases like...",
                "Water covers ' ' of the Earth's surface.",
                "How far is the Sun from Earth?",
                "The Sun is about...",
                "A solar eclipse occurs when...",
                "Which is the hottest planet in the solar system?",
                "What was the name of the first living being to go into outer space?",
                "In how many million years will the Sun run out of hydrogen and become a white dwarf?",
                "What is the most abundant element in the universe?",
                "Which theory explains the origin of the universe?",
                "What is the name of the galaxy where our solar system is located?",
                "What type of star will the Sun become when it runs out of fuel?",
                "What are black holes?",
                "What is the closest galaxy to the Milky Way?",
                "What is the distance that light travels in a year called?",
                "What is a supernova?",
                "Which of the following objects does not emit its own light?",
                "What force holds galaxies together?",
                "What is the Earth's core mainly composed of?",
                "Which layer of the Earth lies between the crust and the core?",
                "Which is the largest ocean on Earth?",
                "What is the highest point above sea level on Earth?",
                "What is the \"greenhouse effect\"?",
                "What type of rock forms from the solidification of magma?",
                "Which layer of the atmosphere is where most weather phenomena occur?",
                "What is the process by which rocks break down and turn into soil?",
                "Which of the following is a continent?",
                "What is the outermost layer of the solar atmosphere?"
        };
        //PRIMERA RESPUESTA CORRECTA, SEPARADAS POR GUION
        String [] Respuestas = {
                "6-5-7-4 ",
                "Hydrogen and helium, but they are very sparse.-Carbon-Hydrogen-Oxygen ",
                "70%-65%-50%-80%",
                "4.5 billion years old-34 million years old-6.7 billion years old-7.8 billion years old",
                "The Moon passes between the Sun and the Earth-The Sun passes between the Moon and the Earth-The Earth passes between the Sun and the Moon-It doesn’t happen",
                "Venus-Mars-Jupiter-Pluto",
                "Jupiter-Saturn-Pluto-Mars",
                "Laika-Rayka-Neil Armstrong-No one has ever gone ",
                "5,000,000,000-8,000,000,000-7,000,000,000-6,000,000,000",
                "Hydrogen-Helium-Oxygen-Carbon",
                "Big Bang Theory-Quantum Theory-Expansion Theory-Armstrong's Theory ",
                "Milky Way-Andromeda-Triangulum-Spiral",
                "White Dwarf-Neutron star-Black hole-Supernova",
                "Very dense stars-Regions of space with extremely strong gravity-Stars in formation-Clouds of interstellar gas",
                "Andromeda Galaxy-Sombrero Galaxy-Large Magellanic Cloud-Triangulum Galaxy",
                "Light year-Stellar year-Astronomical unit-Galactic year",
                "An explosion of a star in its final stage-A giant planet-A comet entering an atmosphere-A galaxy in formation",
                "Star-Comet-Pulsar-Black hole",
                "Gravity-Nuclear force-Electromagnetism-Cosmic radiation",
                "Iron and nickel-Hydrogen-Silicon-Carbon",
                "Mantle-Hydrosphere-Atmosphere-Outer core",
                "Pacific Ocean-Atlantic Ocean-Indian Ocean-Arctic Ocean ",
                "Mount Everest-Mount Kilimanjaro-Mount Aconcagua-Mount McKinley ",
                "A process by which certain gases trap heat in the atmosphere-A phenomenon that causes rain-Cloud formation-A type of weather phenomenon",
                "Igneous rock-Sedimentary rock-Metamorphic rock-Volcanic rock",
                "Troposphere-Stratosphere-Mesosphere-Thermosphere ",
                "Weathering-Erosion-Sedimentation-Compaction ",
                "Antarctica-Greenland-Easter Island-Borneo",
                "Corona-Core-Radiarion Zone-Chromosphere"
        };
        Question [] medium_q = new Question[Preguntas.length];
        Question q;
        for(int i=0; i<Preguntas.length; i++){
            q = new Question(1, false);
            ArrayList<String> q_answers = answer_splitter(Respuestas[i]);
            q.setTitle(Preguntas[i]);
            q.setPossible_answers(q_answers);
            q.setCorrect_answer(q_answers.get(0));
            medium_q[i] = q;
        }

        return medium_q;
    }
//---------------------------------------------------------------------------------------------
    public Question[] hardquestions(){
        String [] Preguntas = {
                "The mesosphere has a thickness of... ",
                "In the thermosphere, the temperature in this layer can reach: ",
                "When is it called a \"tropical storm\"?",
                "Can you see stars during the day?",
                "Gases of the Sun...",
                "The Sun holds our entire solar system together thanks to...",
                "What is the rotation period of Mercury?",
                "What is the atmosphere of Venus made of?",
                "What size are the particles that make up Saturn’s ring system?",
                "What is the average distance from the Sun to the Earth?",
                "What type of galaxy is the Milky Way?",
                "What is a quasar?",
                "What is the most commonly used unit of measurement for astronomical distances within our solar system?",
                "What is the main process that produces the Sun's energy?",
                "What is a pulsar?",
                "What is the likely fate of a star with a mass greater than the Sun at the end of its life?",
                "What phenomenon is known as \"gravitational lensing\"?",
                "What is cosmic microwave background radiation?",
                "What element is formed in the core of massive stars before they explode as supernovas?",
                "What is the main component of emission nebulae?",
                "Which law describes the expansion of the universe?",
                "What is a Kerr black hole?",
                "What are the young, hot, blue stars found in open clusters called?",
                "What is the main characteristic of a Cepheid variable star?",
                "What is the \"cosmological constant\" in Einstein’s theory of relativity?",
                "What are galaxies with no defined shape called?",
                "What is an \"accretion disk\"?",
                "What is the distance in parsecs to a star with a parallax of 1 arcsecond?",
                "What phenomenon causes starlight to shift towards the red in the spectrum?",
                "What is the \"event horizon\" of a black hole?"
        };
        //PRIMERA RESPUESTA CORRECTA, SEPARADAS POR GUION
        String [] Respuestas = {
                "35 kilometers-10 kilometers-60 kilometers-120 kilometers",
                "4500 degrees Fahrenheit-5400 degrees Fahrenheit-5600 degrees Fahrenheit-4600 degrees Fahrenheit",
                "When the wind reaches 63 km/h-When the wind reaches 64 km/h-When the wind reaches 65 km/h-It doesn’t exist",
                "Yes, but only one-I’m not sure-Yes-No",
                "71% hydrogen, 27% helium, and 2% heavier elements-71% helium, 27% hydrogen, and 2% heavier elements-78% hydrogen, 19% helium, and 2% heavier elements-78% hydrogen, 27%% helium, and 2% heavier elements",
                "Gravity-The other planets-The Sun doesn’t hold it together-Anderson's law",
                "58.7 days-67.89 days-59.92 days-59.3 days",
                "Carbon dioxide and some nitrogen-Oxygen-Nitrogen dioxide and some carbon-Hydrogen and carbon",
                "Microscopic and a few meters large-Macroscopic-Microscopic-There are no particles",
                "149,600,000 million km-146,600,000 million km-148,600,000 million km-147,600,000 million km",
                "Barred spiral-Elliptical-Simple spiral-Helicoidal spiral",
                "A supermassive black hole emitting radiation-A very old star-A planet in formation-Main element in a star",
                "Astronomical unit (AU)-Kilometers/h-Light Years-Meters/s²",
                "Nuclear fission-Nuclear fusion-Radioactive decay-Pyruvate oxidation",
                "A type of galaxy-A dwarf planet-A neutron star-A component of an atom ",
                "It forms a black hole-It becomes a white dwarf-It forms a neutron star-It creates a supernova",
                "The bending of light by the gravity of a massive object-The expansion of the universe-The collision of two galaxies-The generation of new galaxies",
                "Remnants of the Big Bang-Emissions from young stars-Radio waves from the galaxy-Pulses of sunlight",
                "Iron-Hydrogen-Helium-Mercury ",
                "Ionized hydrogen-Cosmic dust-Cosmic rays-Metallic elements",
                "Hubble's law-Kepler's law-The law of universal gravitation-The principle of energy conservation",
                "A rapidly spinning black hole-A static black hole-A black hole with an electric charge-A black hole in formation",
                "O-type stars-T Tauri stars-Main-sequence stars-Neonatal stars",
                "Its brightness varies regularly-It changes position in the sky-It becomes a supernova-It emits dark matter",
                "A term that describes the accelerated expansion of the universe-A value that describes the speed of light-The force of gravitational attraction-Formula for body lift",
                "Irregular galaxies-Spiral galaxies-Elliptical galaxies-Phantom galaxies",
                "A ring of matter surrounding a black hole or star-A cloud of interstellar dust-A star cluster-The orbit of a planet around its star",
                "1 parsec-10 parsecs-0.1 parsecs-100 parsecs",
                "The Doppler effect due to the expansion of the universe-The absorption of light by stellar dust-The collision of stars-The rotation of galaxies",
                "The boundary beyond which nothing, not even light, can escape-The zone where light can still escape-The outermost region of a black hole-The outer region of a black hole"
        };
        Question [] hard_q = new Question[Preguntas.length];
        Question q;
        for(int i=0; i<Preguntas.length; i++){
            q = new Question(2, false);
            ArrayList<String> q_answers = answer_splitter(Respuestas[i]);
            q.setTitle(Preguntas[i]);
            q.setPossible_answers(q_answers);
            q.setCorrect_answer(q_answers.get(0));
            hard_q[i] = q;
        }

        return hard_q;
    }

    public ArrayList<String> answer_splitter(String Respuesta){
        String[] splitted_ans = Respuesta.split("-");
        ArrayList<String> list_splitted_ans = new ArrayList<String>();
        for (int i = 0; i < splitted_ans.length; i++) {
            list_splitted_ans.add(splitted_ans[i]);
        }
        return list_splitted_ans;
    }


    public Question[] getQuestions_table() {
        return questions_table;
    }

    public void setQuestions_table(Question[] questions_table) {
        this.questions_table = questions_table;
    }

    public int getDiff_selected() {
        return diff_selected;
    }

    public void setDiff_selected(int diff_selected) {
        this.diff_selected = diff_selected;
    }
}
