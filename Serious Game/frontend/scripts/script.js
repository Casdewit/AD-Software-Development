// runs full game
function checkAnswer(round, canvasNumber, measureAnswer) {
    // ROUND 1
    if (round === 1) {
        switch (measureAnswer) {
            case 'a':
                return 3;
            case 'b':
                return 1;
            case 'c':
                return 2;
        }
        // ROUND 2
    } else if (round === 2) {
        if (canvasNumber === 1) {
            switch (measureAnswer) {
                case 'a':
                    return 0;
                case 'b':
                    return 1;
                case 'c':
                    return 2;
            }
        } else if (canvasNumber === 2) {
            switch (measureAnswer) {
                case 'a':
                    return 1;
                case 'b':
                    return 2;
                case 'c':
                    return 3;
            }
        } else if (canvasNumber === 3) {
            switch (measureAnswer) {
                case 'a':
                    return 2;
                case 'b':
                    return 3;
                case 'c':
                    return 4;
            }
        }
// ROUND 3
    } else if (round === 3) {
        if (canvasNumber === 0) {
            switch (measureAnswer) {
                case 'a':
                    return 0;
                case 'b':
                    return 1;
                case 'c':
                    return 1;
            }
        } else if (canvasNumber === 1) {
            switch (measureAnswer) {
                case 'a':
                    return 0;
                case 'b':
                    return 2;
                case 'c':
                    return 1;
            }
        } else if (canvasNumber === 2) {
            switch (measureAnswer) {
                case 'a':
                    return 1;
                case 'b':
                    return 3;
                case 'c':
                    return 2;
            }
        } else if (canvasNumber === 3) {
            switch (measureAnswer) {
                case 'a':
                    return 2;
                case 'b':
                    return 4;
                case 'c':
                    return 3;
            }
        } else if (canvasNumber === 4) {
            switch (measureAnswer) {
                case 'a':
                    return 3;
                case 'b':
                    return 4;
                case 'c':
                    return 3;
            }
        }
        // ROUND 4
    } else if (round === 4) {
        if (canvasNumber === 0) {
            switch (measureAnswer) {
                case 'a':
                    return 0;
                case 'b':
                    return 1;
                case 'c':
                    return 1;
            }
        } else if (canvasNumber === 1) {
            switch (measureAnswer) {
                case 'a':
                    return 0;
                case 'b':
                    return 2;
                case 'c':
                    return 1;
            }
        } else if (canvasNumber === 2) {
            switch (measureAnswer) {
                case 'a':
                    return 1;
                case 'b':
                    return 3;
                case 'c':
                    return 2;
            }
        } else if (canvasNumber === 3) {
            switch (measureAnswer) {
                case 'a':
                    return 2;
                case 'b':
                    return 4;
                case 'c':
                    return 3;
            }
        } else if (canvasNumber === 4) {
            switch (measureAnswer) {
                case 'a':
                    return 3;
                case 'b':
                    return 4;
                case 'c':
                    return 3;
            }
        }
        // ROUND 5
    } else if (round === 5) {
        if (canvasNumber === 0) {
            switch (measureAnswer) {
                case 'a':
                    return 1;
                case 'b':
                    return 1;
                case 'c':
                    return 0;
            }
        } else if (canvasNumber === 1) {
            switch (measureAnswer) {
                case 'a':
                    return 2;
                case 'b':
                    return 1;
                case 'c':
                    return 0;
            }
        } else if (canvasNumber === 2) {
            switch (measureAnswer) {
                case 'a':
                    return 3;
                case 'b':
                    return 2;
                case 'c':
                    return 1;
            }
        } else if (canvasNumber === 3) {
            switch (measureAnswer) {
                case 'a':
                    return 4;
                case 'b':
                    return 3;
                case 'c':
                    return 2;
            }
        } else if (canvasNumber === 4) {
            switch (measureAnswer) {
                case 'a':
                    return 4;
                case 'b':
                    return 3;
                case 'c':
                    return 3;
            }
        }
    }// THE END
    else if (round === 6) {

    }
}